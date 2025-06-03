package itu.mg.new_app.service.salary;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.salary.Salary_Structure;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.service.API_Service;

@Service
public class Salary_Structure_service {
    


    @Autowired private API_Service api_Service;
    private final String doctype = "Salary Structure";

    // public List <Salary_Structure> submit (String doc) {

    //     Save_body body = new Save_body();
    //     body.setDoc(doc);
    //     body.setAction("Submit");
    //     Salary_StructureSave salary_StructureSave = api_Service.API_submit (body, HttpMethod.POST, new ParameterizedTypeReference<Salary_StructureSave>() {});
    //     return salary_StructureSave.getDocs();
    // }

    // public List <Salary_Structure> submit (String name, int docstatus) {

    //     Map <String, Object> parametres = new HashMap<>();

    //     Salary_Component_List salary_Component_List = api_Service.API_resource(doctype+"/"+name, parametres, body, HttpMethod.PUT, new ParameterizedTypeReference<Salary_Component_List>() {});

    // }


    public Salary_Structure save (Salary_Structure_body salary_Structure_body) throws Exception {
        Map <String, Object> parametres = new HashMap<>();
        Salary_Structure_List salary_Structure_List = api_Service.API_resource(doctype, parametres, salary_Structure_body, HttpMethod.POST, new ParameterizedTypeReference<Salary_Structure_List>() {});

        if (salary_Structure_List.getException() != null && !salary_Structure_List.getException().isEmpty()) {
            throw new Exception(salary_Structure_List.getExc_type()+" "+salary_Structure_List.getException());
        } else {
            return salary_Structure_List.getData();
        }
    }

    public List <Salary_Structure> save_submit (Set <Salary_Structure_body> salary_structures, boolean submit) throws Exception {
        List <Salary_Structure> structures = new ArrayList<>();

        for (Salary_Structure_body ssBody : salary_structures) {
            if (submit) ssBody.setDocstatus(1);
            try {
                structures.add(save(ssBody));
            } catch (Exception e) {
                throw e;
            }
        }
        return structures;
    }

}

class Salary_Structure_List {
    private Salary_Structure data;
    private String exception;
    private String exc_type;

    public Salary_Structure_List () {}

    public String getExc_type() { return exc_type; }
    public String getException() { return exception; }

    public void setExc_type(String exc_type) { this.exc_type = exc_type; }
    public void setException(String exception) { this.exception = exception; }

    public Salary_Structure getData() {
        return data;
    }
    public void setData(Salary_Structure data) {
        this.data = data;
    }
}
