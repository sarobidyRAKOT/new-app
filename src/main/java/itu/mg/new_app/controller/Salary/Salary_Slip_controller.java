package itu.mg.new_app.controller.Salary;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import itu.mg.new_app.model.Utils.Graphe;
import itu.mg.new_app.model.salary.*;
import itu.mg.new_app.models_form.*;
import itu.mg.new_app.service.salary.*;
import itu.mg.new_app.utilitaires.*;
import itu.mg.new_app.utilitaires.Month;

@Controller
public class Salary_Slip_controller {

    @Autowired private Salary_Slip_service salary_Slip_service;



    @GetMapping ("/employee-Salary")
    public String page_dashboard (@ModelAttribute Filtre_Mois_form mois_form, Model model) {

        Parameters parameters = Parameters.get_instance(); // 
        parameters.addField("fields", "[\"*\"]");
        parameters.addFilter("payroll_frequency", "=", "Monthly");
        
        if (!mois_form.validForm()) {
            LocalDate now = LocalDate.now();
            mois_form.setAnnees(now.getYear());
            mois_form.setMois(now.getMonthValue());
        }

        YearMonth yearMonth = YearMonth.of(mois_form.getAnnees(), mois_form.getMois());
        LocalDate startDate = yearMonth.atDay(1);            
        LocalDate endDate = yearMonth.atEndOfMonth();
        parameters.addFilter("start_date", ">=", startDate.toString());
        parameters.addFilter("end_date", "<=", endDate.toString());
        

        Salary_Slip salary_Slip_Total = new Salary_Slip();
        List <Salary_Slip> salary_Slips = salary_Slip_service.get_allWith(parameters);
        

        if (salary_Slips != null && salary_Slips.size()>0) {
            salary_Slip_Total.setCurrency(salary_Slips.get(0).getCurrency());
            for (Salary_Slip salary_Slip : salary_Slips) {
                salary_Slip_Total.somme (salary_Slip);
            }
        }
        // Salary_Slip_Total salary_Slip_Total = Salary_Slip_Total.calculer(salary_Slips);
        
        model.addAttribute("salary_Slips", salary_Slips);
        model.addAttribute("salary_Slip_Total", salary_Slip_Total);
        model.addAttribute("mois_form", mois_form);
        model.addAttribute("mois", Month.values());
        model.addAttribute("annees", Arrays.asList(2023, 2024, 2025));
        model.addAttribute("page", "dashboard/employee-salary");
        return "main-page";
    }


    @GetMapping ("/employee-Salary/all/{year}")
    public String page_salarySlipDetailsAll_Employee (@PathVariable(required=true) int year, Model model) {

        Parameters parameters = Parameters.get_instance(); // 
        parameters.addField("fields", "[\"*\"]");
        parameters.addFilter("payroll_frequency", "=", "Monthly");
        parameters.addFilter("start_date", ">=", year+"-01-01");
        parameters.addFilter("end_date", "<=", year+"-12-31");
        
        Salary_Slip salary_Slip_Total = new Salary_Slip();
        List <Salary_Slip> salary_Slips = salary_Slip_service.get_allWith(parameters);
        
        if (salary_Slips != null && salary_Slips.size()>0) {
            salary_Slip_Total.setCurrency(salary_Slips.get(0).getCurrency());
            for (Salary_Slip salary_Slip : salary_Slips) {
                salary_Slip_Total.somme (salary_Slip);
            }
        }
        
        model.addAttribute("salary_Slips", salary_Slips);
        model.addAttribute("salary_Slip_Total", salary_Slip_Total);
        model.addAttribute("mois_form", new Filtre_Mois_form());
        model.addAttribute("mois", Month.values());
        model.addAttribute("annees", Arrays.asList(2023, 2024, 2025));
        model.addAttribute("page", "dashboard/employee-salary");
        return "main-page";
    }

    
    @GetMapping ("/salary-statistic")
    public String page_Salary_Statistic (@RequestParam (required = false, value = "annees") Integer annees, Model model) {

        if (annees == null || annees <= 0) {
            annees = LocalDate.now().getYear();
        }
        Map <Month, Salary_Slip> somme = salary_Slip_service.somme_salary_slipBy(annees);
        
        Salary_Slip salary_Slip_Total = new Salary_Slip ();
        if (somme != null && !somme.isEmpty()) {  
            salary_Slip_Total.setCurrency(somme.values().iterator().next().getCurrency());    
            for (Salary_Slip ss : somme.values()) salary_Slip_Total.somme (ss);
        }
        
        model.addAttribute("salary_Slip_Total", salary_Slip_Total);
        model.addAttribute("year", annees);
        model.addAttribute("salary_Slips", somme);
        model.addAttribute("annees", Arrays.asList(2023, 2024, 2025));
        model.addAttribute("page", "dashboard/salary-statistic");
        return "main-page";
    }


    
    @GetMapping ("/salary-evolution")
    public String page_Salary_Evolution (@RequestParam(value="annees", required=false) Integer annees, Model model) {

        // Integer a = Integer.parseInt(annees);
        
        if (annees == null || annees <= 0) {
            annees = LocalDate.now().getYear();
        }
        Map <Month, Salary_Slip> somme = salary_Slip_service.somme_salary_slipBy(annees);

        Graphe g = new Graphe();
        for (Month month : Month.values()) {
            Salary_Slip ss = somme.get(month);
            if (ss == null) {
                ss = new Salary_Slip();
            }
            g.getTotal_salary().add(ss.getNet_pay());
            g.getTotal_earnings().add(ss.getTotal_earnings());
            g.getTotal_deductions().add(ss.getTotal_deduction());
            g.getGross_pay().add(ss.getGross_pay());
        }

        model.addAttribute("annees", Arrays.asList(2023, 2024, 2025));
        model.addAttribute("realData", g.getTotal_salary());
        model.addAttribute("total_deductions", g.getTotal_deductions());
        model.addAttribute("total_earnings", g.getGross_pay());
        // model.addAttribute("total_earnings", g.getTotal_earnings());
        model.addAttribute("page", "dashboard/salary-evolution");
        return "main-page";
    }


    @GetMapping ("/salary-slip/details")
    public String page_salary_SlipDetails (@RequestParam(value="name",required=true) String name, Model model) {

        Salary_Slip salary_Slip = salary_Slip_service.get_by(name, null);

        model.addAttribute("salary_Slip", salary_Slip);
        model.addAttribute("currency", salary_Slip.getCurrency());
        model.addAttribute("salary_detailsEarnings", salary_Slip.getEarnings());
        model.addAttribute("salary_detailsDeductions", salary_Slip.getDeductions());
        model.addAttribute("page", "salary/salary-slip-details");
        return "main-page";
    }


    @GetMapping ("/salary-slip/{month}")
    public String page_salary_SlipDetail (@PathVariable (required=true, value="month") Month month, @RequestParam (required=true, defaultValue="year") Integer year) {
        return "redirect:/employee-Salary?mois="+month.getNumero()+"&annees="+year;
    }





}
