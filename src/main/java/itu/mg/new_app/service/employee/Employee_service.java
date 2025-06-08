package itu.mg.new_app.service.employee;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


import itu.mg.new_app.model.employee.*;
import itu.mg.new_app.models_form.*;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.service.*;
import itu.mg.new_app.utilitaires.*;

@Service
public class Employee_service {
    

    @Autowired private API_Service api_Service;
    private final String doctype = "Employee";
    private final ParameterizedTypeReference <Json_Result <Employee>> ref_single = new ParameterizedTypeReference<Json_Result<Employee>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Employee>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Employee>>>() {};

    public List <Employee> get_all () {

        Parameters parameters = Parameters.get_instance();
        parameters.addField ("fields", "[\"*\"]");

        Json_Result <List<Employee>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);

        return result.getData(); 
    }

    public List <Employee> get_all_WithFilter (Filtre_Employee_form filter) {

        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "[\"*\"]");   

        if (filter.getGender() != null && !filter.getGender().isEmpty())  parameters.addFilter("gender", "=", filter.getGender());   
        if (filter.getDepartment() != null && !filter.getDepartment().isEmpty())  parameters.addFilter("department", "=", filter.getDepartment());   
        if (filter.getCompany() != null && !filter.getCompany().isEmpty())  parameters.addFilter("company", "=", filter.getCompany());   
        if (filter.getDesignation() != null && !filter.getDesignation().isEmpty())  parameters.addFilter("designation", "=", filter.getDesignation());   
        if (filter.getStatus() != null && !filter.getStatus().isEmpty())  parameters.addFilter("status", "=", filter.getStatus());   
        if (filter.getDate_of_birthMin() != null)  parameters.addFilter("date_of_birth", ">=", filter.getDate_of_birthMin().toString()); 
        if (filter.getDate_of_birthMax() != null)  parameters.addFilter("date_of_birth", "<=", filter.getDate_of_birthMax().toString());
    
        Json_Result <List <Employee>> employees = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        return employees.getData(); 
    }


    public Employee get_by (String employee, Parameters parameters) throws Exception {

        Json_Result <Employee> result = api_Service.API_resource(doctype+"/"+employee, null, parameters, HttpMethod.GET, ref_single);
        if (result.getData() != null) {
            return result.getData(); 
        } else {
            throw new Exception("PAS D'EMPLOYEE POUR LE EMPLOYEE "+employee); 
        }
    }



    public Employee save (Employee_body employee_body) throws Exception {
        
        
        Json_Result <Employee> result = api_Service.API_resource(doctype, employee_body, null, HttpMethod.POST, ref_single);

        if (result.getException() != null && !result.getException().isEmpty()) {
            throw new Exception(result.getExc_type()+" "+result.getException());
        } else {
            return result.getData();
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
