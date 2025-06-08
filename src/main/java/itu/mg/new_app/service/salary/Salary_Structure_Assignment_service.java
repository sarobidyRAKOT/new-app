package itu.mg.new_app.service.salary;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


import itu.mg.new_app.model.salary.*;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.*;

@Service
public class Salary_Structure_Assignment_service {
    
    @Autowired private  API_Service api_Service;
    private final String doctype = "Salary Structure Assignment";
    private final ParameterizedTypeReference <Json_Result <Salary_Structure_Assignment>> ref_single = new ParameterizedTypeReference<Json_Result<Salary_Structure_Assignment>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Salary_Structure_Assignment>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Salary_Structure_Assignment>>>() {};


    public Salary_Structure_Assignment save (Salary_Structure_assignment_body salary_Structure_assignment_body) throws Exception {
       
        Json_Result <Salary_Structure_Assignment> result = api_Service.API_resource(doctype, salary_Structure_assignment_body, null, HttpMethod.POST, ref_single);

        if (result.getException() != null && !result.getException().isEmpty()) {
            throw new Exception(result.getExc_type()+" "+result.getException());
        } else {
            return result.getData();
        }
    }

    public List <Salary_Structure_Assignment> get_AllWith (Parameters parameters) {
                
        
        Json_Result <List <Salary_Structure_Assignment>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        
        return result.getData();
    }

    public List <Salary_Structure_Assignment> save (Set <Salary_Structure_assignment_body> salary_Structure_assignment_bodies, boolean submit) throws Exception {
        
        List <Salary_Structure_Assignment> salary_Structure_Assignments = new ArrayList<>();

        for (Salary_Structure_assignment_body ssaB : salary_Structure_assignment_bodies) {
            if (submit) ssaB.setDocstatus(1);
            try {
                salary_Structure_Assignments.add(save(ssaB));
            } catch (Exception e) {
                throw e;
            }
        }
        return salary_Structure_Assignments;
    }

    
}
