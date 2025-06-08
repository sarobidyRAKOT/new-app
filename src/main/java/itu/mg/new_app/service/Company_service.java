package itu.mg.new_app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.Company;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.utilitaires.*;

@Service
public class Company_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Company";
    private final ParameterizedTypeReference <Json_Result <Company>> ref_single = new ParameterizedTypeReference<Json_Result<Company>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Company>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Company>>>() {};


    public Company save (Company_body company_body) throws Exception {


        Json_Result <Company> result = api_Service.API_resource(doctype, company_body, null, HttpMethod.POST, ref_single);

        if (result.getException() != null && !result.getException().isEmpty()) {
            throw new Exception(result.getExc_type()+" "+result.getException());
        } else {
            return result.getData();
        }
    }

    public List <Company> save (Set <Company_body> companies) throws Exception {

        List <Company> cs = new ArrayList<>();

        for (Company_body company : companies) {
            try {
                cs.add(this.save(company));
            } catch (Exception e) {
                throw e;
            }
        }
        return cs;
    }

    public List <Company> get_all () {
        
        // ParameterizedTypeReference ref = Reference_Type.get_instance();
        
        // ParameterizedTypeReference <Json_Result <List <Company>>> reference = new ParameterizedTypeReference<Json_Result< List <Company> >>() {};
        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "\"*\"");
        
        Json_Result <List<Company>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        return result.getData();
    }

}
