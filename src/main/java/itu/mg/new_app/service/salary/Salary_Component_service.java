package itu.mg.new_app.service.salary;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.salary.Salary_Component;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.*;

@Service
public class Salary_Component_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Salary Component";
    private final ParameterizedTypeReference <Json_Result <Salary_Component>> ref_single = new ParameterizedTypeReference<Json_Result<Salary_Component>>() {};
    // private final ParameterizedTypeReference <Json_Result <List<Salary_Component>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Salary_Component>>>() {};


    public Salary_Component save (Salary_Component_body salary_Component_body) throws Exception {
        
        Json_Result <Salary_Component> result = api_Service.API_resource(doctype, salary_Component_body, null, HttpMethod.POST, ref_single);

        if (result.getException() != null && !result.getException().isEmpty()) {
            throw new Exception(result.getExc_type()+" "+result.getException());
        } else {
            return result.getData();
        }
    }
    
    public List <Salary_Component> save (Set <Salary_Component_body> salary_Componant_Bodies) throws Exception  {
    
        List <Salary_Component> scs = new ArrayList<>();
        for (Salary_Component_body scBody : salary_Componant_Bodies) {
            try {
                scs.add(save(scBody));
            } catch (Exception e) {
                throw e;
            }
        }
        
        return scs;
    }

}

