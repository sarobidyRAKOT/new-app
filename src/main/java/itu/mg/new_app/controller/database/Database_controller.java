package itu.mg.new_app.controller.database;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import itu.mg.new_app.model.form.ImportFile_form;
import itu.mg.new_app.service.*;
import itu.mg.new_app.service.database.*;
import itu.mg.new_app.service.employee.*;
import itu.mg.new_app.service.salary.*;
import itu.mg.new_app.service.utils.*;
import itu.mg.new_app.utilitaires.result_import.*;
import itu.mg.new_app.utilitaires.traitement_import.*;


@Controller
public class Database_controller  {
    
    @Autowired private CSV csv;
    @Autowired private API_Service api_Service;
    @Autowired private Company_service company_service;
    @Autowired private Employee_service employee_service;
    @Autowired private Salary_Component_service salary_Component_service;
    @Autowired private Salary_Structure_service salary_Structure_service;
    @Autowired private Salary_Structure_Assignment_service salary_Structure_Assignment_service;
    @Autowired private Holiday_List_service holiday_List_service;
    @Autowired private Salary_Slip_service salary_Slip_service;

    @GetMapping ("/database/import-file")
    public String page_formImportFile (Model model) {

        ImportFile_form importFile_form = new ImportFile_form();

        model.addAttribute("importFile_form", importFile_form);
        model.addAttribute("page", "database/form-import-file");
        return "main-page";
    }


    @PostMapping ("/database/import-file")
    public String traitement_formImprtFile (@ModelAttribute ImportFile_form importFile_form, Model model) throws JsonProcessingException {

        List <String> errors = new ArrayList<>();

        if (!csv.validerFichier(importFile_form.getFichier1(), "eF1", model) ||
            !csv.validerFichier(importFile_form.getFichier2(), "eF2", model) ||
            !csv.validerFichier(importFile_form.getFichier3(), "eF3", model)) {
            model.addAttribute("page", "database/form-import-file");
            return "main-page";
        }


        
        Fichier_1 fichier_1 = csv.import_CSV(importFile_form.getFichier1(), new Import_fichier1 (company_service.get_all()));
        Fichier_2 fichier_2 = csv.import_CSV(importFile_form.getFichier1(), new Import_fichier2 ());
        Fichier_3 fichier_3 = csv.import_CSV(importFile_form.getFichier1(), new Import_fichier3 ());
    
        errors.addAll(fichier_1.getErrors());
        errors.addAll(fichier_2.getErrors());
        errors.addAll(fichier_3.getErrors());
        


        if (errors.size() > 0) {
            model.addAttribute("errors", errors);  
            model.addAttribute("page", "database/form-import-file");
            return "main-page";
        }

        // VERIFICATION SALARY STRUCTURE ASSIGNMENT et SALARY STRUCTURE ***

        try {
            // holiday_List_service.save(fichier_1.getHoliday_List_body());
            // company_service.save(fichier_1.getCompany_bodies());
            // employee_service.save(fichier_1.getEmployee_bodies());
            // salary_Component_service.save(fichier_2.getSalary_Component_bodies());
            // salary_Structure_service.save(fichier_2.getSalary_Structure_bodies(), true);
            // salary_Structure_Assignment_service.save(fichier_3.getSalary_Structure_Assignments(), true);
            // salary_Slip_service.save(fichier_3.getSalary_Slips(), false);

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


    @GetMapping ("/database/init-database")
    public String init_database () {
        // appelle API *** 
        Response response = api_Service.API_ReinitialiserDBA(null, null, new ParameterizedTypeReference<Response>() {});
        System.out.println(response.getMessage().getStatus());
        return "redirect:/employee-list";
    }



}

class Response {
    private Message message;
    public Response () {}
    public Message getMessage() { return message; }
    public void setMessage(Message message) { this.message = message; }
}
class Message {
    private String status;
    private List <String> successfully_cleared;
    private List <String> failed;

    public Message () {}
    public List<String> getFailed() {return failed; }
    public String getStatus() {return status; }
    public List<String> getSuccessfully_cleared() {return successfully_cleared; }

    public void setFailed(List<String> failed) {this.failed = failed; }
    public void setStatus(String status) {this.status = status; }
    public void setSuccessfully_cleared(List<String> successfully_cleared) {this.successfully_cleared = successfully_cleared; }
}

