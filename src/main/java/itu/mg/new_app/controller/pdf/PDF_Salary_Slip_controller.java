package itu.mg.new_app.controller.pdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import itu.mg.new_app.model.salary.Salary_Slip;
import itu.mg.new_app.service.salary.Salary_Slip_service;
import itu.mg.new_app.utilitaires.*;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/pdf")
public class PDF_Salary_Slip_controller {
    
    @Autowired private Salary_Slip_service salary_Slip_service;

    @GetMapping ("/export/salary-slip")
    public String page_exportSalarySlipPDF (@RequestParam (required = true, defaultValue = "salary_slip") String salary_slip, Model model) {
        
        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "[\"*\"]");

        Salary_Slip ss = salary_Slip_service.get_by(salary_slip, parameters);

        model.addAttribute("salary_Slip", ss);
        model.addAttribute("page", "pdf/export-salary-slip");
        return "main-page";
    }

    @GetMapping("/download/salary-slip")
    public void generatePdf (HttpServletResponse servletResponse, @RequestParam(required = true, defaultValue = "salary_slip") String salary_slip) {

        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "[\"*\"]");
        Salary_Slip ss = salary_Slip_service.get_by(salary_slip, parameters);
        salary_Slip_service.telechargerPDF_Salary_Slip(servletResponse, ss);
        // return "redirect:/pdf/export/salary-slip?salary_slip="+salary_slip;

    }
}