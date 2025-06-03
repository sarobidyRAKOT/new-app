package itu.mg.new_app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import itu.mg.new_app.config.ApiProperties;

@Service
public class API_Service {
    

    @Autowired private ApiProperties API_properties;
    @Autowired private RestTemplate restTemplate;
    @Autowired private ObjectMapper mapper;

    public <T> T API (String url, Object body, HashMap <String, Object> parametres, 
        HttpMethod method,ParameterizedTypeReference<T> responseType, boolean token) {

        String uri = API_properties.getBaseUrl()+""+url;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (token) {
            headers.set("Authorization", "token " + API_properties.getToken());
        }

        Map<String, Object> params = new HashMap<>();
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        
        // if (headersMap != null && headersMap.size() > 0) {
        //     for (String key : headersMap.keySet()) headers.set(key, headersMap.get(key));
        // }
        if (parametres != null && parametres.size() > 0) {
            for (String key : parametres.keySet()) params.put (key, parametres.get(key));
        }
        
        ResponseEntity<T> response = restTemplate.exchange(uri, method, entity, responseType, params);

        return response.getBody();
    }

    public <T> T API_List (Object body, HashMap <String, Object> parametres, HttpMethod method,ParameterizedTypeReference<T> responseType) {

        String uri = API_properties.getBaseUrl()+""+API_properties.getAPI_list();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token " + API_properties.getToken());

        Map<String, Object> params = new HashMap<>();
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        

        if (parametres != null && parametres.size() > 0) {
            for (String key : parametres.keySet()) params.put (key, parametres.get(key));
        }
        
        ResponseEntity<T> response = restTemplate.exchange(uri, method, entity, responseType, params);

        return response.getBody();
    }


    public <T> T API_once (Object body, HashMap <String, Object> parametres, HttpMethod method,ParameterizedTypeReference<T> responseType) {

        String uri = API_properties.getBaseUrl()+""+API_properties.getAPI_once();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token " + API_properties.getToken());

        Map<String, Object> params = new HashMap<>();
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        
        if (parametres != null && parametres.size() > 0) {
            for (String key : parametres.keySet()) params.put (key, parametres.get(key));
        }
        
        ResponseEntity<T> response = restTemplate.exchange(uri, method, entity, responseType, params);

        return response.getBody();
    }


    public <T> T API_submit (Object body, HttpMethod method, ParameterizedTypeReference<T> responseType) {

        String uri = API_properties.getBaseUrl()+""+API_properties.getAPI_submit();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token " + API_properties.getToken());

        Map<String, Object> params = new HashMap<>();
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);

        
        ResponseEntity<T> response = restTemplate.exchange(uri, method, entity, responseType, params);

        return response.getBody();
    }

    public <T> T API_resource (String doctype, Map <String, Object> parametres, Object body, HttpMethod method, ParameterizedTypeReference<T> responseType) throws JsonProcessingException {

        String uri = API_properties.getBaseUrl()+"/api/resource/"+doctype;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token " + API_properties.getToken());
        
        
        String b = mapper.writeValueAsString(body);
        HttpEntity<JsonNode> entity = new HttpEntity<>(mapper.readTree(b), headers);
        
        Map<String, Object> params = new HashMap<>();
        if (parametres != null && parametres.size() > 0) {
            for (String key : parametres.keySet()) params.put (key, parametres.get(key));
        }
        
        ResponseEntity<T> response = restTemplate.exchange(uri, method, entity, responseType, params);

        return response.getBody();
    }

}
