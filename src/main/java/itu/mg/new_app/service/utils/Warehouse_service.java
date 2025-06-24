package itu.mg.new_app.service.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.Utils.Warehouse;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.others.Json_Result;
import itu.mg.new_app.utilitaires.others.Parameters;

@Service
public class Warehouse_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Warehouse";
    private final ParameterizedTypeReference <Json_Result <List <Warehouse>>> ref_list = new ParameterizedTypeReference<Json_Result<List <Warehouse>>>() {};

    public List <Warehouse> get_allWith (Parameters parameters) {
        Json_Result <List <Warehouse>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        return result.getData();
    }


}
