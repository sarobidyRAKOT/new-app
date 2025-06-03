package itu.mg.new_app.service.employee;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import itu.mg.new_app.model.employee.Employee;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.service.API_Service;

@Service
public class Employee_service {
    

    @Autowired private API_Service api_Service;
    private final String doctype = "Employee";

    public List <Employee> get_all () throws JsonProcessingException {

        // Map <String, Object> parametres = new HashMap<>();
        
        // String s = "[\"*\"]";
        // String a = "[\\\"*\\\"]";
        // System.out.println(s+" "+a);
        // parametres.put("fields", "[\"*\"]");

        Employee_List employee_List = api_Service.API_resource(doctype+"?fields=[\"*\"]", null, null, HttpMethod.GET, new ParameterizedTypeReference<Employee_List>() {});
        return employee_List.getData(); 
    }


    public Employee save (Employee_body employee_body) throws Exception {
        
        Map <String, Object> parametres = new HashMap<>();
        Employees_Save employees_Save = api_Service.API_resource(doctype, parametres, employee_body, HttpMethod.POST, new ParameterizedTypeReference<Employees_Save>() {});

        if (employees_Save.getException() != null && !employees_Save.getException().isEmpty()) {
            throw new Exception(employees_Save.getExc_type()+" "+employees_Save.getException());
        } else {
            return employees_Save.getData();
        }

    }

    public List <Employee> save (Set <Employee_body> employees) throws Exception {

        List <Employee> es = new ArrayList<>();
        for (Employee_body employee : employees) {
            try {
                es.add(this.save(employee));
            } catch (Exception e) {
                throw e;
            }
        }

        return es;
    }

}

class Employee_List {
    
    List <Employee> data;
    public Employee_List () {} 
    public void setData(List<Employee> data) { this.data = data; }
    public List<Employee> getData() { return data; }
}

class Employees_Save {

    private Employee data;
    private String exception;
    private String exc_type;

    public Employees_Save () {}
    public String getExc_type() { return exc_type; }
    public String getException() { return exception; }
    
    public Employee getData() {
        return data;
    }
    public void setData(Employee data) {
        this.data = data;
    }
    public void setExc_type(String exc_type) { this.exc_type = exc_type; }
    public void setException(String exception) { this.exception = exception; }
}
