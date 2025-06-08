package itu.mg.new_app.service.supplier;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.mg.new_app.model.Item;
import itu.mg.new_app.model.Purchase_invoice;
import itu.mg.new_app.model.Warehouse;
import itu.mg.new_app.model.supplier.Request_forQuotation;
import itu.mg.new_app.model.supplier.Supplier;
import itu.mg.new_app.models_form.body.List_body;
import itu.mg.new_app.service.API_Service;




@Service
public class Request_ForQuotation_service {

    @Autowired private API_Service api_Service;
    
    public List <Request_forQuotation> get_all (String supplierName) {

        List_body body = new List_body();
        body.setDoctype("Request for Quotation");
        body.setFields(Arrays.asList("name", "supplier_name", "supplier_group", "tax_id", "creation"));
        HashMap<String, Object> filtre = new HashMap<>();
        filtre.put("name", supplierName);
        body.setFilters(filtre);
        
        Request_forQuotationList request_forQuotationList = api_Service.API_List(body, null, HttpMethod.POST, new ParameterizedTypeReference<Request_forQuotationList>() {});

        return request_forQuotationList.getMessage();        
    }




    // public List <SupplierQuotationItem> annuler_SupplierQuotation (String supplierQuotation_name) {
    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.form.save.cancel";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token "+super.apiProperties.getToken());

    //     // Construire le body JSON
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doctype", "Supplier Quotation");
    //     body.put("name", supplierQuotation_name);


    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );


    //     // RECUPERATION ITEMS 

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     JsonNode rootNode;
    //     List <SupplierQuotationItem> items = new ArrayList <SupplierQuotationItem> ();

        
        
    //     try {
    //         rootNode = objectMapper.readTree(response.getBody());
    //         JsonNode docsNode = rootNode.get("docs").get(0); // TSY MAINTSY MISY SATRY DETAIL FACTURE ************
    //         JsonNode itemsNode = docsNode.get("items");
            
    //         SupplierQuotationItem[] itemsArray = objectMapper.treeToValue(itemsNode, SupplierQuotationItem[].class);
    //         items = Arrays.asList(itemsArray);
            
    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }
            
    //     return items;
        
    // }

    // public void amended_SupplierQuotation (String supplierQuotation_name) {
    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.client.is_document_amended";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token "+super.apiProperties.getToken());

    //     // Construire le body JSON
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doctype", "Supplier Quotation");
    //     body.put("name", supplierQuotation_name);


    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );
    //     response.getBody();

    // }


    // public void nouveau_version () {

    // }


    // public ArrayNode get_supplierQuotaionBy (String supplierQuotation_name) {

    //     String url = super.apiProperties.getBaseUrl() +"/api/resource/Supplier Quotation/"+supplierQuotation_name;
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token "+super.apiProperties.getToken());


    //     HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
    //     ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     JsonNode rootNode;

        
        
    //     try {

    //         rootNode = objectMapper.readTree(response.getBody());
    //         JsonNode dataNode = rootNode.get("data");
    //         ArrayNode items = (ArrayNode) dataNode.get("items");

    //         return items;
    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }
        
    //     return null;
        
    // } 

    // public String update_supplierQuotationItem_prix (ArrayNode items, HashMap <String, Double> new_prix, String supplierQuotation_name) {


    //     for (JsonNode itemNode : items) {
    //         ObjectNode itemObject = (ObjectNode) itemNode;
    //         String itemCode = itemObject.get("item_code").asText();

    //         if (new_prix.containsKey(itemCode)) {
    //             double nouveauRate = new_prix.get(itemCode);
    //             double qty = itemObject.get("qty").asDouble();

    //             itemObject.put("rate", nouveauRate);
    //             itemObject.put("amount", nouveauRate * qty);
    //             itemObject.put("base_rate", nouveauRate);
    //             itemObject.put("base_amount", nouveauRate * qty);
    //             itemObject.put("net_rate", nouveauRate);
    //             itemObject.put("net_amount", nouveauRate * qty);
    //             itemObject.put("base_net_rate", nouveauRate);
    //             itemObject.put("base_net_amount", nouveauRate * qty);
    //         }
    //     }

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     ObjectNode updatePayload = objectMapper.createObjectNode();
    //     updatePayload.set("items", items);  // Tous les items modifiés
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token "+super.apiProperties.getToken());

    //     HttpEntity<String> entity;
    //     try {
    //         entity = new HttpEntity<>(objectMapper.writeValueAsString(updatePayload), headers);
    //         String url = super.apiProperties.getBaseUrl() +"/api/resource/Supplier Quotation/"+supplierQuotation_name;
    //         ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);

            
            
    //         return get_supplierQuotaion(supplierQuotation_name);

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }
            
    //     return null;

    // }


    // public String get_supplierQuotaion (String supplierQuotation_name) {

    //     String url = super.apiProperties.getBaseUrl() +"/api/resource/Supplier Quotation/"+supplierQuotation_name;
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token "+super.apiProperties.getToken());


    //     HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
    //     ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        

        
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     JsonNode rootNode;

        
        
    //     try {

    //         rootNode = objectMapper.readTree(response.getBody());
    //         ObjectNode Odoc = (ObjectNode) rootNode.get("data");

    //         // Créer le noeud "__onload"
    //         Odoc.put("doctype", "Supplier Quotation");
    //         ObjectNode onloadNode = objectMapper.createObjectNode();
    //         onloadNode.put("make_payment_via_journal_entry", 0);
    //         onloadNode.put("backflush_based_on", "BOM");

    //         // Générer la date/heure actuelle en ISO 8601
    //         String currentTimestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

    //         // Ajouter ou mettre à jour les champs dans Odoc
    //         Odoc.set("__onload", onloadNode);
    //         Odoc.put("__last_sync_on", currentTimestamp);
    //         Odoc.put("__unsaved", 1);


    //         return rootNode.get("data").toString();

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }
        
    //     return null;
        
    // } 

    // public void submit_requestSupplierQuotation (String doc) {

    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.form.save.savedocs";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());

    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doc", doc);
    //     body.put("action", "Submit");
        
    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        
    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     // return response.getBody();
    // }


    // public List <Item> get_allItems () {

    //     List <Item> items = new ArrayList<> ();


    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.reportview.get";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());


    //     // Construire le body JSON
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doctype", "Item");
    //     body.put("fields", Arrays.asList(
    //         "`tabItem`.`name`","`tabItem`.`owner`","`tabItem`.`creation`","`tabItem`.`modified`",
    //         "`tabItem`.`modified_by`","`tabItem`.`_user_tags`","`tabItem`.`_comments`","`tabItem`.`_assign`",
    //         "`tabItem`.`_liked_by`","`tabItem`.`docstatus`","`tabItem`.`idx`","`tabItem`.`item_group`","`tabItem`.`item_name`",
    //         "`tabItem`.`image`","`tabItem`.`stock_uom`","`tabItem`.`has_variants`","`tabItem`.`end_of_life`",
    //         "`tabItem`.`disabled`","`tabItem`.`variant_of`"
    //     ));
        
    //     body.put("filters", new ArrayList<>());
    //     body.put("view", "List");
    //     body.put("with_comment_count", 1);

    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    //     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //     JsonNode rootNode;
    //     try {


    //         rootNode = objectMapper.readTree(response.getBody());
    //         JsonNode messageNode = rootNode.get("message");
    //         JsonNode valuesNode = messageNode.get("values");  // <-- On récupère le tableau ici
    //         List<String> keys = new ArrayList<>();
    //         messageNode.get("keys").forEach(node -> keys.add(node.asText()));

    //         for (JsonNode row : valuesNode) {
    //             items.add(Item.jsonToItem(keys, row, dateTimeFormatter, dateFormatter));
    //         }

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }

    //     return items;
    // }


    // public List <Item> get_allPorpose () {

    //     List <Item> items = new ArrayList<> ();


    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.reportview.get";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());


    //     // Construire le body JSON
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doctype", "Item");
    //     body.put("fields", Arrays.asList(
    //         "`tabItem`.`name`","`tabItem`.`owner`","`tabItem`.`creation`","`tabItem`.`modified`",
    //         "`tabItem`.`modified_by`","`tabItem`.`_user_tags`","`tabItem`.`_comments`","`tabItem`.`_assign`",
    //         "`tabItem`.`_liked_by`","`tabItem`.`docstatus`","`tabItem`.`idx`","`tabItem`.`item_group`","`tabItem`.`item_name`",
    //         "`tabItem`.`image`","`tabItem`.`stock_uom`","`tabItem`.`has_variants`","`tabItem`.`end_of_life`",
    //         "`tabItem`.`disabled`","`tabItem`.`variant_of`"
    //     ));
        
    //     body.put("filters", new ArrayList<>());
    //     body.put("view", "List");
    //     body.put("with_comment_count", 1);

    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    //     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //     JsonNode rootNode;
    //     try {


    //         rootNode = objectMapper.readTree(response.getBody());
    //         JsonNode messageNode = rootNode.get("message");
    //         JsonNode valuesNode = messageNode.get("values");  // <-- On récupère le tableau ici
    //         List<String> keys = new ArrayList<>();
    //         messageNode.get("keys").forEach(node -> keys.add(node.asText()));

    //         for (JsonNode row : valuesNode) {
    //             items.add(Item.jsonToItem(keys, row, dateTimeFormatter, dateFormatter));
    //         }

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }

    //     return items;
    // }


    // public List <Warehouse> get_allPwareHouse () {

    //     List <Warehouse> warehouses = new ArrayList<> ();

    //     String url = super.apiProperties.getBaseUrl() + "/api/method/erpnext.stock.doctype.warehouse.warehouse.get_children";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());


    //     // Construire le body JSON
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doctype", "Warehouse");
    //     body.put("company", "ITU Company");
    //     body.put("parent", "ITU Company");
    //     body.put("is_root", true);

        
    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     JsonNode rootNode;
    //     try {


    //         rootNode = objectMapper.readTree(response.getBody());
    //         JsonNode messageNode = rootNode.get("message");

    //         Warehouse[] wh = objectMapper.treeToValue(messageNode, Warehouse[].class);
    //         warehouses = Arrays.asList(wh);

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }

    //     return warehouses;
    // }



    // String doc = "";
    // String items = "        {\r\n" + //
    //             "            \"docstatus\":0,\r\n" + //
    //             "            \"doctype\":\"Material Request Item\",\r\n" + //
    //             "            \"name\":\"new-material-request-item-zvayfsdils\",\r\n" + //
    //             "            \"__islocal\":1,\r\n" + //
    //             "            \"__unsaved\":1,\r\n" + //
    //             "            \"owner\":\"Administrator\",\r\n" + //
    //             "            \"stock_uom\":\"Nos\",\r\n" + //
    //             "            \"page_break\":0,\r\n" + //
    //             "            \"parent\":\"new-material-request-ynrcwarxxo\",\r\n" + //
    //             "            \"parentfield\":\"items\",\r\n" + //
    //             "            \"parenttype\":\"Material Request\",\r\n" + //
    //             "            \"idx\":1,\r\n" + //
    //             "            \"schedule_date\":\"2025-05-08\",\r\n" + //
    //             "            \"warehouse\":\"All Warehouse - IC\",\r\n" + //
    //             "            \"image\":null,\"item_code\":\"boulon\",\r\n" + //
    //             "            \"rate\":0,\r\n" + //
    //             "            \"uom\":\"Nos\",\r\n" + //
    //             "            \"qty\":1,\r\n" + //
    //             "            \"amount\":0,\r\n" + //
    //             "            \"pricing_rules\":\"\",\r\n" + //
    //             "            \"conversion_factor\":1,\r\n" + //
    //             "            \"stock_qty\":1\r\n" + //
    //             "        }";


    // public String request_material (String doc, String action) {



                
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     JsonNode rootNode;

        
        
    //     try {

    //         rootNode = objectMapper.readTree(doc);
    //         ObjectNode Odoc = (ObjectNode) rootNode.get("data");

    //         // Créer le noeud "__onload"
    //         Odoc.put("doctype", "Supplier Quotation");
    //         ObjectNode onloadNode = objectMapper.createObjectNode();
    //         onloadNode.put("make_payment_via_journal_entry", 0);
    //         onloadNode.put("backflush_based_on", "BOM");

    //         // Générer la date/heure actuelle en ISO 8601
    //         String currentTimestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

    //         // Ajouter ou mettre à jour les champs dans Odoc
    //         Odoc.set("__onload", onloadNode);
    //         Odoc.put("__last_sync_on", currentTimestamp);
    //         Odoc.put("__unsaved", 1);


    //         return rootNode.get("data").toString();

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }


    //     return null;
    // }

    // public String request_supplierQuotation (String doc) {

    //     return null;
    // }




    // *******************************



}

class Request_forQuotationList {
    private List <Request_forQuotation> message;
    public Request_forQuotationList () {}
    public void setMessage(List<Request_forQuotation> message) { this.message = message; }
    public List<Request_forQuotation> getMessage() { return message; }
    
}


