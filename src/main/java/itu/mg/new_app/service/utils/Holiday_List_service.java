package itu.mg.new_app.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.Utils.Holiday_List;
import itu.mg.new_app.model.body.Holiday_List_body;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.others.Json_Result;

@Service
public class Holiday_List_service {
    
    @Autowired private API_Service api_Service;
    private String doctype = "Holiday List";
    private final ParameterizedTypeReference <Json_Result <Holiday_List>> ref_single = new ParameterizedTypeReference<Json_Result<Holiday_List>>() {};


    public Holiday_List save (Holiday_List_body holyDays_body) throws Exception {
        Json_Result <Holiday_List> result = api_Service.API_resource(doctype, holyDays_body, null, HttpMethod.POST, ref_single);

        if (result.getException() != null && !result.getException().isEmpty()) {
            throw new Exception(result.getExc_type()+" "+result.getException());
        } else {
            return result.getData();
        }
    }
}
