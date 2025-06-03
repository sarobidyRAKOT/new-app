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

import itu.mg.new_app.model.salary.Salary_Structure_Assignment;
import itu.mg.new_app.models_form.body.Salary_Structure_assignment_body;
import itu.mg.new_app.service.API_Service;

@Service
public class Salary_Structure_Assignment_service {
    
    @Autowired private  API_Service api_Service;
    private final String doctype = "Salary Structure Assignment";

    public Salary_Structure_Assignment save (Salary_Structure_assignment_body salary_Structure_assignment_body) throws Exception {
        Map <String, Object> parametres = new HashMap<>();
        // parametres.put("fields", "[\\\"*\\\"]");
        Salary_Structure_Assignment_Save salary_Structure_Assignment_Save = api_Service.API_resource(doctype, parametres, salary_Structure_assignment_body, HttpMethod.POST, new ParameterizedTypeReference<Salary_Structure_Assignment_Save>() {});

        if (salary_Structure_Assignment_Save.getException() != null && !salary_Structure_Assignment_Save.getException().isEmpty()) {
            throw new Exception(salary_Structure_Assignment_Save.getExc_type()+" "+salary_Structure_Assignment_Save.getException());
        } else {
            return salary_Structure_Assignment_Save.getData();
        }
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

class Salary_Structure_Assignment_List {

}

class Salary_Structure_Assignment_Save {

    private Salary_Structure_Assignment data;
    private String exception;
    private String exc_type;

    public Salary_Structure_Assignment_Save () {}
    public String getExc_type() { return exc_type; }
    public String getException() { return exception; }
    public Salary_Structure_Assignment getData() { return data; }

    public void setData(Salary_Structure_Assignment data) { this.data = data; }
    public void setExc_type(String exc_type) { this.exc_type = exc_type; }
    public void setException(String exception) { this.exception = exception; }
    
}