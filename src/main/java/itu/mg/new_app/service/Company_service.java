package itu.mg.new_app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import itu.mg.new_app.model.Company;
import itu.mg.new_app.models_form.body.*;

@Service
public class Company_service {
    
    @Autowired private API_Service api_Service;
    private final String doctype = "Company";


    public Company save (Company_body company_body) throws Exception {
        Map <String, Object> parametres = new HashMap<>();
        // parametres.put("fields", "[\\"*\\"]");
        Company_save companys_save = api_Service.API_resource(doctype, parametres, company_body, HttpMethod.POST, new ParameterizedTypeReference<Company_save>() {});

        if (companys_save.getException() != null && !companys_save.getException().isEmpty()) {
            throw new Exception(companys_save.getExc_type()+" "+companys_save.getException());
        } else {
            return companys_save.getData();
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

    public List <Company> get_all () throws JsonProcessingException {

        Map <String, Object> parametres = new HashMap<>();
        parametres.put("fields", "[\\\"*\\\"]");
        Company_List company_List = api_Service.API_resource(doctype, parametres, null, HttpMethod.GET, new ParameterizedTypeReference<Company_List>() {});
        return company_List.getData();
    }

}


class Company_List {
    private List <Company> data;
    public Company_List () {}
    public List<Company> getData() { return data; }
    public void setData(List<Company> data) { this.data = data; }
}

class Company_save {
    private Company data;
    private String exception;
    private String exc_type;

    public Company_save () {}

    public Company getData() {return data; }
    public String getExc_type() {return exc_type; }
    public String getException() {return exception; }
    public void setData(Company data) {this.data = data; }
    public void setExc_type(String exc_type) {this.exc_type = exc_type; }
    public void setException(String exception) {this.exception = exception; }
}
 