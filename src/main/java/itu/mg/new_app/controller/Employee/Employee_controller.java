package itu.mg.new_app.controller.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import itu.mg.new_app.model.employee.Employee;
import itu.mg.new_app.service.employee.*;

@Controller
public class Employee_controller {
    
    @Autowired private Employee_service employee_service;

    @GetMapping ("/employee-list")
    public String page_employeeList (Model model) throws JsonProcessingException {

        List <Employee> employees = employee_service.get_all();

        model.addAttribute("employees", employees);
        model.addAttribute("page", "employee/list-employee");
        return "main-page";
    }

}
