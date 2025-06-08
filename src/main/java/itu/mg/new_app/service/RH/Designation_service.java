package itu.mg.new_app.service.RH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.RH.Designation;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.*;

@Service
public class Designation_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Designation";
    // private final ParameterizedTypeReference <Json_Result <Designation>> ref_single = new ParameterizedTypeReference<Json_Result<Designation>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Designation>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Designation>>>() {};

    
    public List <Designation> get_all () {
        
        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "[\"*\"]");
        Json_Result <List <Designation>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        return result.getData();
    }
    

}

