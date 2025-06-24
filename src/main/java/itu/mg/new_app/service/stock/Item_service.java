package itu.mg.new_app.service.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.stock.Item;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.others.*;

@Service
public class Item_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Item";
    private final ParameterizedTypeReference <Json_Result <List <Item>>> ref_list = new ParameterizedTypeReference<Json_Result<List <Item>>>() {};


    public List <Item> get_allWith (Parameters parameters) {

        Json_Result <List <Item>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        return result.getData();
    }

    
}
