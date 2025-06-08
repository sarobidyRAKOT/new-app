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
public class Salary_Structure_service {
    


    @Autowired private API_Service api_Service;
    private final String doctype = "Salary Structure";
    private final ParameterizedTypeReference <Json_Result <Salary_Structure>> ref_single = new ParameterizedTypeReference<Json_Result<Salary_Structure>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Salary_Structure>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Salary_Structure>>>() {};

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

        Json_Result <Salary_Structure> result = api_Service.API_resource(doctype, salary_Structure_body, null, HttpMethod.POST, ref_single);

        if (result.getException() != null && !result.getException().isEmpty()) {
            throw new Exception(result.getExc_type()+" "+result.getException());
        } else {
            return result.getData();
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

