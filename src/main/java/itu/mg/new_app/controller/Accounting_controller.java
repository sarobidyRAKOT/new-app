package itu.mg.new_app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.mg.new_app.model.Payment_entry;
import itu.mg.new_app.model.Purchase_invoice;
import itu.mg.new_app.service.Default_service;
import itu.mg.new_app.service.Purchase_invoice_service;

@Controller
public class Accounting_controller {
    
    private final String FILE_PATH = "save_payment.json";
    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired Purchase_invoice_service purchase_invoice_service;

    @GetMapping ("/list/facture")
    public String liste_facturePage (Model model) {

        List <Purchase_invoice> purchase_invoices = purchase_invoice_service.get_all();
        // System.out.println(purchase_invoices.size());
        model.addAttribute("purchase_invoices", purchase_invoices);
        model.addAttribute("page", "list-purchaseInvoice");
        return "main-page";
    }

    @GetMapping ("/detail/facture")
    public String detail_facturePage (Model model, @RequestParam("purchase_invoice") String purchase_invoice) {

        model.addAttribute("purchase_invoice", purchase_invoice_service.get_By(purchase_invoice));
        model.addAttribute("items", purchase_invoice_service.get_ItemPurchaseInvoice_By(purchase_invoice));

        model.addAttribute("page", "detail-purchaseInvoice");
        return "main-page";
    }

    
    @GetMapping ("/paiement")
    public String payement_page (Model model, @RequestParam("purchase_invoice") String purchase_invoice) {

        Payment_entry payment_entry = purchase_invoice_service.payment_entry(purchase_invoice, FILE_PATH);
     
        model.addAttribute("payment_entry", payment_entry);

        model.addAttribute("page", "paiement-facture");
        return "main-page";
    }

    @SuppressWarnings("null")
    @PostMapping("/paiement/sauvgarder")
    public String save_paiement (@ModelAttribute Payment_entry payment_entry, Model model) {

        // System.out.println(payment_entry.getPaid_amount()+" "+payment_entry.getReference_no());
        File file = new File(FILE_PATH);
        String name1 = Default_service.generateTempName("payment-entry");
        String name2 = Default_service.generateTempName("payment-entry-reference");
        
        try {
            JsonNode rootNode = objectMapper.readTree(file);
            JsonNode messageNode = rootNode.get("message");

            if (messageNode != null && messageNode.isObject()) {
                ObjectNode objectNode = (ObjectNode) messageNode;
            
                objectNode.put("paid_amount", payment_entry.getPaid_amount());
                objectNode.put("base_paid_amount", payment_entry.getPaid_amount());
                objectNode.put("received_amount", payment_entry.getPaid_amount());
                objectNode.put("base_received_amount", payment_entry.getPaid_amount());
                objectNode.put("total_allocated_amount", payment_entry.getPaid_amount());
                objectNode.put("base_total_allocated_amount", payment_entry.getPaid_amount());
                objectNode.put("name", name1);
                objectNode.put("reference_no", payment_entry.getReference_no());
            
                // Modifier "references"
                JsonNode ref = messageNode.get("references");
                if (ref != null && ref.isArray() && ref.size() > 0) {
                    ObjectNode firstReference = (ObjectNode) ref.get(0);
                    firstReference.put("allocated_amount", payment_entry.getPaid_amount());
                    firstReference.put("parent", name1);
                    firstReference.put("name", name2);
                }
            }
            
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
            
            String submit_doc = purchase_invoice_service.Save_paiement(messageNode.toString());
            
            // file.delete(); // supprimer le fichier contenant les données JSON
            
            rootNode = objectMapper.readTree(submit_doc);
            JsonNode doc = rootNode.get("docs").get(0);
            ObjectNode Odoc = (ObjectNode) doc;

            Odoc.remove("localname");
            Odoc.put("__last_sync_on", Instant.now().toString());
        
            purchase_invoice_service.Valider_paiement(doc.toString());
            // System.out.println(doc.toPrettyString());
            
            file.delete(); // supprimer le fichier **************
            model.addAttribute("page", "valider-paiement");
            return "redirect:/list/facture";

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
        
    }


}
