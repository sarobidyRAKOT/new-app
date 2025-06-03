package itu.mg.new_app.service.supplier;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.supplier.Supplier;
import itu.mg.new_app.models_form.body.List_body;
import itu.mg.new_app.service.API_Service;

@Service
public class Supplier_service  {
    
    @Autowired private API_Service api_Service;


    public List <Supplier> get_all () {

        List_body body = new List_body();
        body.setDoctype("Supplier");
        body.setFields(Arrays.asList("name", "supplier_name", "supplier_group", "tax_id", "creation"));

        SupplierList supplierList = api_Service.API_List(body, null, HttpMethod.POST, new ParameterizedTypeReference<SupplierList>() {});
        
        return supplierList.getMessage();
    }


    public Supplier getByName (String supplierName) {
    
        List_body body = new List_body();
        HashMap<String, Object> filtre = new HashMap<>();
        filtre.put("name", supplierName);
        body.setDoctype("Supplier");
        body.setFilters(filtre);

        SupplierInner supplierInner = api_Service.API_once(body, null, HttpMethod.POST, new ParameterizedTypeReference<SupplierInner>() {});

        return supplierInner.getMessage();
    }
    

}

class SupplierList {
    private List <Supplier> message;
    public SupplierList () {}
    public List<Supplier> getMessage() { return message; }
    public void setMessage(List<Supplier> message) { this.message = message; }
} 

class SupplierInner {
    private Supplier message;
    public SupplierInner () {}
    public void setMessage(Supplier message) { this.message = message; }
    public Supplier getMessage() { return message; }
    
}


