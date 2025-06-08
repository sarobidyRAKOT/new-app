package itu.mg.new_app.service;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.mg.new_app.model.Item;
import itu.mg.new_app.model.Payment_entry;
import itu.mg.new_app.model.Purchase_invoice;


@Service
public class Purchase_invoice_service  {
    

    // public List <Purchase_invoice> get_all () {
    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.reportview.get";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());

    //     // Construire le body JSON
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doctype", "Purchase Invoice");
    //     body.put("fields", Arrays.asList(
    //         "`tabPurchase Invoice`.`name`","`tabPurchase Invoice`.`owner`","`tabPurchase Invoice`.`creation`","`tabPurchase Invoice`.`modified`","`tabPurchase Invoice`.`modified_by`","`tabPurchase Invoice`.`_user_tags`","`tabPurchase Invoice`.`_comments`",
    //         "`tabPurchase Invoice`.`_assign`","`tabPurchase Invoice`.`_liked_by`","`tabPurchase Invoice`.`docstatus`","`tabPurchase Invoice`.`idx`","`tabPurchase Invoice`.`posting_date`","`tabPurchase Invoice`.`total`","`tabPurchase Invoice`.`net_total`",
    //         "`tabPurchase Invoice`.`tax_withholding_net_total`","`tabPurchase Invoice`.`taxes_and_charges_added`","`tabPurchase Invoice`.`taxes_and_charges_deducted`","`tabPurchase Invoice`.`total_taxes_and_charges`","`tabPurchase Invoice`.`grand_total`","`tabPurchase Invoice`.`rounding_adjustment`",
    //         "`tabPurchase Invoice`.`rounded_total`","`tabPurchase Invoice`.`total_advance`","`tabPurchase Invoice`.`outstanding_amount`","`tabPurchase Invoice`.`discount_amount`","`tabPurchase Invoice`.`paid_amount`","`tabPurchase Invoice`.`write_off_amount`","`tabPurchase Invoice`.`status`",
    //         "`tabPurchase Invoice`.`title`","`tabPurchase Invoice`.`supplier`","`tabPurchase Invoice`.`supplier_name`","`tabPurchase Invoice`.`base_grand_total`","`tabPurchase Invoice`.`due_date`","`tabPurchase Invoice`.`company`","`tabPurchase Invoice`.`currency`","`tabPurchase Invoice`.`is_return`",
    //         "`tabPurchase Invoice`.`release_date`","`tabPurchase Invoice`.`on_hold`","`tabPurchase Invoice`.`represents_company`","`tabPurchase Invoice`.`is_internal_supplier`","`tabPurchase Invoice`.`party_account_currency`"
    //     ));
        
    //     body.put("filters", new ArrayList<>());
    //     body.put("order_by", "`tabPurchase Invoice`.creation desc");
    //     body.put("view", "List");
    //     body.put("with_comment_count", 1);

    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     List<Purchase_invoice> purchase_invoices = new ArrayList<>();
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
    //             purchase_invoices.add(Purchase_invoice.jsonToPurchaseInvoice (keys, row, dateTimeFormatter, dateFormatter));
    //         }


    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }


    //     return purchase_invoices;
    // }


    // public Purchase_invoice get_By (String purchaseInvoice_name) {

    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.reportview.get";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());

    //     // Construire le body JSON
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doctype", "Purchase Invoice");
    //     body.put("fields", Arrays.asList(
    //         "`tabPurchase Invoice`.`name`","`tabPurchase Invoice`.`owner`","`tabPurchase Invoice`.`creation`","`tabPurchase Invoice`.`modified`","`tabPurchase Invoice`.`modified_by`","`tabPurchase Invoice`.`_user_tags`","`tabPurchase Invoice`.`_comments`",
    //         "`tabPurchase Invoice`.`_assign`","`tabPurchase Invoice`.`_liked_by`","`tabPurchase Invoice`.`docstatus`","`tabPurchase Invoice`.`idx`","`tabPurchase Invoice`.`posting_date`","`tabPurchase Invoice`.`total`","`tabPurchase Invoice`.`net_total`",
    //         "`tabPurchase Invoice`.`tax_withholding_net_total`","`tabPurchase Invoice`.`taxes_and_charges_added`","`tabPurchase Invoice`.`taxes_and_charges_deducted`","`tabPurchase Invoice`.`total_taxes_and_charges`","`tabPurchase Invoice`.`grand_total`","`tabPurchase Invoice`.`rounding_adjustment`",
    //         "`tabPurchase Invoice`.`rounded_total`","`tabPurchase Invoice`.`total_advance`","`tabPurchase Invoice`.`outstanding_amount`","`tabPurchase Invoice`.`discount_amount`","`tabPurchase Invoice`.`paid_amount`","`tabPurchase Invoice`.`write_off_amount`","`tabPurchase Invoice`.`status`",
    //         "`tabPurchase Invoice`.`title`","`tabPurchase Invoice`.`supplier`","`tabPurchase Invoice`.`supplier_name`","`tabPurchase Invoice`.`base_grand_total`","`tabPurchase Invoice`.`due_date`","`tabPurchase Invoice`.`company`","`tabPurchase Invoice`.`currency`","`tabPurchase Invoice`.`is_return`",
    //         "`tabPurchase Invoice`.`release_date`","`tabPurchase Invoice`.`on_hold`","`tabPurchase Invoice`.`represents_company`","`tabPurchase Invoice`.`is_internal_supplier`","`tabPurchase Invoice`.`party_account_currency`"
    //     ));
        
    //     Map<String, Object> filters = new HashMap<>();
    //     filters.put("name", purchaseInvoice_name);
    //     body.put("filters", filters);
    //     body.put("order_by", "`tabPurchase Invoice`.creation desc");
    //     body.put("view", "List");
    //     body.put("with_comment_count", 1);

    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     List<Purchase_invoice> purchase_invoices = new ArrayList<>();
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
    //             purchase_invoices.add(Purchase_invoice.jsonToPurchaseInvoice (keys, row, dateTimeFormatter, dateFormatter));
    //         }


    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }


    //     return purchase_invoices.get(0);
    // }


    // public List <Item> get_ItemPurchaseInvoice_By (String purchaseInvoice_name) {

        
    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.form.load.getdoc?doctype=Purchase Invoice&name=" + purchaseInvoice_name;

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());
        
    //     HttpEntity<String> entity = new HttpEntity<>(headers);  // Pas besoin de body pour GET
        
    //     // Appel GET avec les paramètres dans l'URL
    //     ResponseEntity<String> response = super.restTemplate.exchange(
    //         url,                  // l’URL
    //         HttpMethod.GET,       // méthode GET
    //         entity,               // les headers
    //         String.class          // type de retour attendu
    //     );


    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    //     JsonNode rootNode;
    //     List <Item> items = new ArrayList <Item> ();

        
        
    //     try {
    //         rootNode = objectMapper.readTree(response.getBody());
    //         JsonNode docsNode = rootNode.get("docs").get(0); // TSY MAINTSY MISY SATRY DETAIL FACTURE ************
    //         JsonNode itemsNode = docsNode.get("items");
            
    //         Item[] itemsArray = objectMapper.treeToValue(itemsNode, Item[].class);
    //         items = Arrays.asList(itemsArray);
            
    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }
            
    //     return items;
    // }

    // public Payment_entry payment_entry (String purchaseInvoice_name, String file_path) {
        
        
    //     String url = super.apiProperties.getBaseUrl() + "/api/method/erpnext.accounts.doctype.payment_entry.payment_entry.get_payment_entry";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());
        
    //     // Construire le body JSON correctement (dt et dn)
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("dt", "Purchase Invoice");           // Type de document
    //     body.put("dn", purchaseInvoice_name);         // Nom de la facture
        
    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        
    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());
    //     objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    //     JsonNode rootNode = null;
    //     Payment_entry payment_entry = new Payment_entry();
                
    //     try {
    //         rootNode = objectMapper.readTree(response.getBody());
    //         JsonNode messageNode = rootNode.get("message");
    //         JsonNode ref = messageNode.get("references").get(0);
    //         String name = ref.get("reference_name").asText();

    //         payment_entry = objectMapper.treeToValue(messageNode, Payment_entry.class);
    //         payment_entry.setReference_name(name);

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }


    //     // ENREGISTEMENT DANS UN FICHIER (DATA)
    //     File file = new File(file_path);
    //     try {
    //         objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
    //     } catch (StreamWriteException e) {
    //         e.printStackTrace();
    //     } catch (DatabindException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

        
    //     return payment_entry;
    // }


    // public String Save_paiement (String doc) {
    //     String url = super.apiProperties.getBaseUrl() + "/api/method/frappe.desk.form.save.savedocs";

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token " + super.apiProperties.getToken());

    //     // Construire le body JSON correctement (dt et dn)
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("doc", doc);
    //     body.put("action", "Save");         // Nom de la facture
        
    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        
    //     ResponseEntity<String> response = super.restTemplate.postForEntity(
    //         url,
    //         entity,
    //         String.class
    //     );

    //     return response.getBody();
    // }

    // public String Valider_paiement (String doc) {
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

    //     return response.getBody();
    // }

}
