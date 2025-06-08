package itu.mg.new_app.service;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import itu.mg.new_app.config.ApiProperties;
import itu.mg.new_app.utilitaires.*;

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

    // public <T> T API_resource (String doctype, Map <String, Object> parametres, Object body, HttpMethod method, ParameterizedTypeReference<T> responseType) throws JsonProcessingException {

    //     String uri = API_properties.getBaseUrl()+"/api/resource/"+doctype;
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + API_properties.getToken());
        
        
    //     String b = mapper.writeValueAsString(body);
    //     HttpEntity<JsonNode> entity = new HttpEntity<>(mapper.readTree(b), headers);
        
    //     Map<String, Object> params = new HashMap<>();
    //     if (parametres != null && parametres.size() > 0) {
    //         for (String key : parametres.keySet()) params.put (key, parametres.get(key));
    //     }
        
    //     ResponseEntity<T> response = restTemplate.exchange(uri, method, entity, responseType, params);

    //     return response.getBody();
    // }


    // public <T> Json_Result <T> API_resource (String doctype, Object body, HashMap <String, Object> parameters, HttpMethod method) {

    //     String baseUrl = API_properties.getBaseUrl();
    //     String uri = baseUrl + "/api/resource/" + doctype;

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + API_properties.getToken());

    //     HttpEntity<Object> entity = new HttpEntity<>(body, headers);
    //     ParameterizedTypeReference<Json_Result<T>> responseType = new ParameterizedTypeReference<>() {};

    //     UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);
    //     if (parameters != null) {
    //         for (Map.Entry<String, Object> entry : parameters.entrySet()) {
    //             builder.queryParam(entry.getKey(), entry.getValue());
    //         } 
    //     }

    //     URI finalUri = builder.build().encode().toUri();

    //     ResponseEntity<Json_Result<T>> response = restTemplate.exchange(
    //         finalUri, method,
    //         entity, responseType
    //     );

    //     return response.getBody();
    // }


    public <T> Json_Result <T> API_resource(String doctype, Object body, Parameters parameters, HttpMethod method, ParameterizedTypeReference<Json_Result<T>> responseType) {
        
        String uri = API_properties.getBaseUrl() + "/api/resource/" + doctype;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token " + API_properties.getToken());

        HttpEntity<Object> entity = new HttpEntity<>(body, headers);

        // ParameterizedTypeReference<Json_Result<T>> responseType = new ParameterizedTypeReference<Json_Result<T>>() {};

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);

        if (parameters == null) {
            parameters = Parameters.get_instance();
        }
        for (Map.Entry<String, Object> entry : parameters.getFields().entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            String filtersJson = mapper.writeValueAsString(parameters.getFilters());
            builder.queryParam("filters", filtersJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erreur lors de la sérialisation des filtres", e);
        }


        URI finalUri = builder.build().encode().toUri();
        ResponseEntity<Json_Result<T>> response = restTemplate.exchange(finalUri, method, entity, responseType);

        return response.getBody();
    }


}
