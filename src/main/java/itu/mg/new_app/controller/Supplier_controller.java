package itu.mg.new_app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.mg.new_app.model.supplier.Purchase_order;
import itu.mg.new_app.model.supplier.Request_forQuotation;
import itu.mg.new_app.model.supplier.Supplier;
import itu.mg.new_app.service.supplier.PurchaseOrder_service;
import itu.mg.new_app.service.supplier.Supplier_service;

@Controller
public class Supplier_controller {
    

    // @Autowired private Supplier_service supplier_service;
    // @Autowired Quotation_service quotation_service;
    // @Autowired private PurchaseOrder_service purchase_order_service;


    // @GetMapping("/list/supplier")
    // public String getSuppliers (Model model) {
        
    //     List <Supplier> suppliers = supplier_service.get_all();
    //     model.addAttribute("suppliers", suppliers);
    //     model.addAttribute("page", "supplier/list-supplier");
    //     return "main-page";
    // }

    
    // @GetMapping("/list/demande-devis") // DEMANDE DE DEVIS FOURNISSEUR ***
    // public String getRequestForuotations(@RequestParam("supplier") String supplierName, Model model) {
        
    //     Supplier supplier = supplier_service.getByName (supplierName);
    //     List<Request_forQuotation> quotations = quotation_service.getBySupplier(supplier_name);

    //     model.addAttribute("quotations", quotations);
    //     model.addAttribute("supplier", supplier);
    //     model.addAttribute("page", "supplier/list-requestForQuotation");
    //     return "main-page";
    // }

    // @GetMapping("/list/commande-supplier") // COMMMANDE FOURNISSEUR ***
    // public String getPurchase_orderBy (@RequestParam("supplier") String supplier_name, Model model) {
        
    //     Supplier supplier = supplier_service.getByName (supplier_name);
    //     List <Purchase_order> purchase_orders = purchase_order_service.get_all (supplier_name);

    //     model.addAttribute("purchase_orders", purchase_orders);
    //     model.addAttribute("supplier", supplier);
    //     model.addAttribute("page", "supplier/list-purchaseOrder");
    //     return "main-page";
    // }


    // @GetMapping ("/supplierQuotation/modifier")
    // public String modifier_supplierQuotation_page (@RequestParam("quotation") String quotation_name, Model model) {

    //     ArrayNode itemsArrayNode = quotation_service.get_supplierQuotaionBy(quotation_name);
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());

    //     List<SupplierQuotationItem> items = new ArrayList<>();
    //     try {
    //         items = objectMapper.readerForListOf(SupplierQuotationItem.class) .readValue(itemsArrayNode);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     // Emballer dans un wrapper
    //     ItemsWrapper itemsWrapper = new ItemsWrapper();
    //     itemsWrapper.setItems(items);

    //     itemsWrapper.setQuotation_name(quotation_name);
    //     model.addAttribute("itemsWrapper", itemsWrapper);

    //     model.addAttribute("page", "update-prixQuotation");

    //     return "main-page";
    // }


    // @PostMapping("/quotation/update")
    // public String updateQuotation(@ModelAttribute ItemsWrapper itemsWrapper) {
        
        
    //     List<SupplierQuotationItem> modifiedItems = itemsWrapper.getItems();

    //     // Ici tu peux parcourir et faire la mise à jour (API ERPNext, base de données, etc.)
    //     HashMap <String, Double> new_prix = new HashMap<>();
    //     for (SupplierQuotationItem item : modifiedItems) {
    //         new_prix.put(item.getItem_code(), item.getRate());
    //         // System.out.println(item.getItem_code() + " -> Nouveau prix : " + item.getRate());
    //     }


    //     ArrayNode items = quotation_service.get_supplierQuotaionBy(itemsWrapper.getQuotation_name());
    //     // System.out.println(items.toPrettyString());
    //     String doc = quotation_service.update_supplierQuotationItem_prix(items, new_prix, itemsWrapper.getQuotation_name());

    //     quotation_service.submit_requestSupplierQuotation(doc);

    //     return "redirect:/list/supplier";
    // }



}

// class ItemsWrapper {
//     private List<SupplierQuotationItem> items;
//     private String quotation_name;

//     public String getQuotation_name() {
//         return quotation_name;
//     }
//     public void setQuotation_name(String quotation_name) {
//         this.quotation_name = quotation_name;
//     }
//     // Getters / Setters
//     public List<SupplierQuotationItem> getItems() {
//         return items;
//     }
//     public void setItems(List<SupplierQuotationItem> items) {
//         this.items = items;
//     }
// }
