package itu.mg.new_app.controller.database;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;

import itu.mg.new_app.model.employee.*;
import itu.mg.new_app.model.salary.Salary_Structure;
import itu.mg.new_app.models_form.ImportFile_form;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.models_form.imports_value.*;
import itu.mg.new_app.service.Company_service;
import itu.mg.new_app.service.database.CSV;
import itu.mg.new_app.service.employee.*;
import itu.mg.new_app.service.salary.Salary_Componant_service;
import itu.mg.new_app.service.salary.Salary_Structure_Assignment_service;
import itu.mg.new_app.service.salary.Salary_Structure_service;
import itu.mg.new_app.utilitaires.traitement.*;


@Controller
public class Database_controller  {
    
    @Autowired private CSV csv;
    @Autowired private Company_service company_service;
    @Autowired private Employee_service employee_service;
    @Autowired private Salary_Componant_service salary_Componant_service;
    @Autowired private Salary_Structure_service salary_Structure_service;
    @Autowired private Salary_Structure_Assignment_service salary_Structure_Assignment_service;

    @GetMapping ("/database/import-file")
    public String page_formImportFile (Model model) {

        ImportFile_form importFile_form = new ImportFile_form();

        model.addAttribute("importFile_form", importFile_form);
        model.addAttribute("page", "database/form-import-file");
        return "main-page";
    }

    @PostMapping ("/database/import-file")
    public String traitement_formImprtFile (@ModelAttribute ImportFile_form importFile_form, Model model) throws JsonProcessingException {


        if (!validerFichier(importFile_form.getFichier1(), "eF1", model) ||
            !validerFichier(importFile_form.getFichier2(), "eF2", model) ||
            !validerFichier(importFile_form.getFichier3(), "eF3", model)) {
            model.addAttribute("page", "database/form-import-file");
            return "main-page";
        }

        Set <Employee_body> employees = new HashSet <> ();
        Set <Company_body> companies = new HashSet <> ();
        Set <Salary_Structure_body> salary_Structures = new HashSet<>();
        Set <Salary_Component_body> salary_Components = new HashSet<>();
        Set <Salary_Structure_assignment_body> salary_Structure_Assignments = new HashSet<>();
        List <String> errors = new ArrayList<>();
        HashMap <String, List<?>> hashMap = new HashMap<>();

        

        hashMap = csv.import_CSV(importFile_form.getFichier1(), new Import_fichier1(company_service.get_all()));
        errors.addAll((List <String>) hashMap.get("errors"));            
        for (Fichier_1 f : (List<Fichier_1>) hashMap.get("items")) {
            if (f.getEmployee_body() != null) employees.add(f.getEmployee_body());
            if (f.getCompany_body() != null) companies.add(f.getCompany_body());
        }

        hashMap = csv.import_CSV(importFile_form.getFichier2(), new Import_fichier2 ());
        errors.addAll((List <String>) hashMap.get("errors"));            
        for (Fichier_2 f2 : (List<Fichier_2>) hashMap.get("items")) {
            salary_Components.add(f2.getSalary_Component_body());
            Salary_Structure_body newStructure = f2.getSalary_Structure_body();

            Optional<Salary_Structure_body> existing = salary_Structures.stream().filter(s -> s.equals(newStructure)).findFirst();

            if (existing.isPresent()) {
                existing.get().getEarnings().addAll(newStructure.getEarnings());
                existing.get().getDeductions().addAll(newStructure.getDeductions());
            } else {
                salary_Structures.add(newStructure);
            }
        }


        hashMap = csv.import_CSV(importFile_form.getFichier3(), new Import_fichier3 ());
        errors.addAll((List <String>) hashMap.get("errors"));
        for (Fichier_3 f3 : (List <Fichier_3>) hashMap.get("items")) {
            if (f3.getSalary_Structure_assignment_body() != null) salary_Structure_Assignments.add(f3.getSalary_Structure_assignment_body());
        }



        if (errors.size() > 0) {
            model.addAttribute("errors", errors);  
            model.addAttribute("page", "database/form-import-file");
            return "main-page";
        }

        try {
            company_service.save(companies);
            List <Employee> es = employee_service.save(employees);
            salary_Componant_service.save(salary_Components);
            List <Salary_Structure> ss = salary_Structure_service.save_submit(salary_Structures, true);
            valider_SalaryStructureAssignment(salary_Structure_Assignments, es, ss);
            salary_Structure_Assignment_service.save(salary_Structure_Assignments, true);

            return "redirect:/database/import-file";
        } catch (Exception e) {
            e.printStackTrace();
            errors.add(e.getMessage());
            model.addAttribute("errors", errors);
            model.addAttribute("page", "database/form-import-file");
            return "main-page";
        }

        // System.out.println(importFile_form.getFichier1().getOriginalFilename()+" "+importFile_form.getFichier2().getOriginalFilename());
    }

    @SuppressWarnings("null")
    private boolean valider_SalaryStructureAssignment (Set <Salary_Structure_assignment_body> salary_Structure_assignment_bodies,
        List <Employee> employees, List <Salary_Structure> salary_Structures) throws Exception {
        
        int i = 0;
        for (Salary_Structure_assignment_body ssaB : salary_Structure_assignment_bodies) {
            // validation SALARY STRUCTURE ASSIGNMENT ****
            Employee e = employees.get(Integer.parseInt(ssaB.getEmployee())-1); // get employee
            Salary_Structure ss = null;
            for (Salary_Structure salary_Structure : salary_Structures) {
                //  GET SALARY STRUCTURE ***
                if (salary_Structure.getName().equals(ssaB.getSalary_structure())) {
                    ss = salary_Structure;
                }
            }

            if (ss != null & e.getCompany().equals(ss.getCompany())) {
                ssaB.setEmployee(e.getEmployee());
                ssaB.setCompany(e.getCompany());
            } else {
                throw new Exception("Invalide Salary structure asignment ligne "+i+1);
            }
            ++ i;
        }
        return true;
    }

    private boolean validerFichier (MultipartFile fichier, String attributErreur, Model model) {
        try {
            csv.isValid(fichier);
            return true;
        } catch (Exception e) {
            model.addAttribute(attributErreur, e.getMessage());
            return false;
        }
    }






}
