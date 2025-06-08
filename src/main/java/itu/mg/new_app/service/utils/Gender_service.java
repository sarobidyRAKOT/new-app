package itu.mg.new_app.service.utils;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


import itu.mg.new_app.model.Utils.Gender;
import itu.mg.new_app.service.*;
import itu.mg.new_app.utilitaires.*;

@Service
public class Gender_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Gender";
    // private final ParameterizedTypeReference <Json_Result <Gender>> ref_single = new ParameterizedTypeReference<Json_Result<Gender>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Gender>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Gender>>>() {};

 
    public List <Gender> get_all () {

        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "\"*\"");

        Json_Result <List <Gender>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        return result.getData();
    }

}

