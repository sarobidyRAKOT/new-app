package itu.mg.new_app.controller.Employee;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import itu.mg.new_app.model.Company;
import itu.mg.new_app.model.RH.*;
import itu.mg.new_app.model.Utils.Gender;
import itu.mg.new_app.model.employee.*;
import itu.mg.new_app.model.salary.*;
import itu.mg.new_app.models_form.*;
import itu.mg.new_app.service.*;
import itu.mg.new_app.service.RH.*;
import itu.mg.new_app.service.employee.*;
import itu.mg.new_app.service.salary.*;
import itu.mg.new_app.service.utils.Gender_service;
import itu.mg.new_app.utilitaires.*;

@Controller
public class Employee_controller {
    
    @Autowired private Employee_service employee_service;
    @Autowired private Gender_service gender_service;
    @Autowired private Department_service department_service;
    @Autowired private Company_service company_service;
    @Autowired private Designation_service designation_service;
    @Autowired private Salary_Structure_Assignment_service salary_Structure_Assignment_service;
    @Autowired private Salary_Slip_service salary_Slip_service;

    @GetMapping ("/employee-list")
    public String page_employeeList (@ModelAttribute Filtre_Employee_form filtre_Employee_form, Model model) throws JsonProcessingException {

        // System.out.println(filtre_Employee_form.getGender());

        List <Gender> genders = gender_service.get_all();
        List <Department> departments = department_service.get_all();
        List <Company> companies = company_service.get_all();
        List <Designation> designations = designation_service.get_all();
        List <Employee> employees = employee_service.get_all_WithFilter(filtre_Employee_form);


        model.addAttribute("filtre_Employee_form", filtre_Employee_form);
        model.addAttribute("genders", genders);
        model.addAttribute("departments", departments);
        model.addAttribute("companies", companies);
        model.addAttribute("designations", designations);
        model.addAttribute("employees", employees);
        model.addAttribute("page", "employee/list-employee");
        return "main-page";
    }


    @GetMapping ("/employee/{employee}") // PROFILE EMPLOYEE *** 
    public String page_Profile_employee (@PathVariable(required = true) String employee, Model model) {
        
        // @{'/employee'(employee=${e.name})} on utilise @ParamRequest 

        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "[\"*\"]");
        parameters.addFilter("payroll_frequency", "=", "Monthly");
        parameters.addFilter("employee", "=", employee);
        
        
        /**
         * Salary Slip -> sans details (deduction & earning)
         *  - Ao daoly na draft na submited
         */
        
        try {
            
            List <Salary_Slip> salary_Slips = salary_Slip_service.get_allWith (parameters);
            
            parameters.remove_filter("payroll_frequency", "=", "Monthly");
            parameters.addFilter("docstatus", "=", 1); // submited
            parameters.addField("order_by", "from_date asc");
            List <Salary_Structure_Assignment> ssa = salary_Structure_Assignment_service.get_AllWith (parameters);
            
            parameters.filters_RemoveAll(); // enlever tous les filtres *** 
            Employee emp = employee_service.get_by(employee, parameters);

            model.addAttribute("Salary_Structure_Assignments", ssa);
            model.addAttribute("salary_Slips", salary_Slips);
            model.addAttribute("employee", emp);
            model.addAttribute("page", "employee/profile-employee");
            return "main-page";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
