package itu.mg.new_app.service.salary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.salary.Salary_Component;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.service.API_Service;

@Service
public class Salary_Componant_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Salary Component";

    public Salary_Component save (Salary_Component_body salary_Component_body) throws Exception {
        
        Map <String, Object> parametres = new HashMap<>();
        // parametres.put("fields", "[\\\"*\\\"]");
        Salary_Component_Save salary_Component_Save = api_Service.API_resource(doctype, parametres, salary_Component_body, HttpMethod.POST, new ParameterizedTypeReference<Salary_Component_Save>() {});

        if (salary_Component_Save.getException() != null && !salary_Component_Save.getException().isEmpty()) {
            throw new Exception(salary_Component_Save.getExc_type()+" "+salary_Component_Save.getException());
        } else {
            return salary_Component_Save.getData();
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

class Salary_Component_Save {

    private Salary_Component data;
    private String exception;
    private String exc_type;

    public Salary_Component_Save () {}

    public String getExc_type() { return exc_type; }
    public String getException() { return exception; }

    public void setExc_type(String exc_type) { this.exc_type = exc_type; }
    public void setException(String exception) { this.exception = exception; }

    public Salary_Component getData() {
        return data;
    }
    public void setData(Salary_Component data) {
        this.data = data;
    }
}
