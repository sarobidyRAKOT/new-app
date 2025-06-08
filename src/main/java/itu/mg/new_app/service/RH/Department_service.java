package itu.mg.new_app.service.RH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


import itu.mg.new_app.model.RH.Department;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.*;

@Service
public class Department_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Department";
    // private final ParameterizedTypeReference <Json_Result <Department>> ref_single = new ParameterizedTypeReference<Json_Result<Department>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Department>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Department>>>() {};

    public List <Department> get_all () {

        Parameters parameters = Parameters.get_instance();
        parameters.addField("fields", "[\"*\"]");
        Json_Result <List <Department>> result = api_Service.API_resource(doctype+"?fields=[\"*\"]", null, parameters, HttpMethod.GET, ref_list);

        return result.getData();

    }

}

