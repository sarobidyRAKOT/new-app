package itu.mg.new_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itu.mg.new_app.model.Item;
import itu.mg.new_app.model.Warehouse;

@Controller
public class RequestSupplierQuotation_controller {
    

    // @Autowired Quotation_service quotation_service;


    // @GetMapping ("/request/supplier/quotation")
    // public String page_requestSupplierQuotation (Model model) {

    //     List <Item> items = quotation_service.get_allItems();
    //     List <Warehouse> warehouses = quotation_service.get_allPwareHouse();

    //     System.out.println(items.size()+" "+warehouses.size());

    //     for (Item item : items) {
    //         System.out.println(item.getName()+" "+item.getItem_code());
    //     }

    //     model.addAttribute("warehouses", warehouses);
    //     model.addAttribute("items", items);

    //     model.addAttribute("page", "form-requestSupplierQuotation");
    //     return "main-page";
    // }


    // @PostMapping ("/request/supplier-quotation")
    // public String requestSupplierQuotation (
    //     @RequestParam("transaction_date") String transactionDate,
    //     @RequestParam("purpose") String purpose,
    //     @RequestParam("warehouse") String warehouse,
    //     @RequestParam("required_by") String requiredBy,
    
    //     @RequestParam("item_code[]") List<String> itemCodes,
    //     @RequestParam("qty[]") List<Integer> quantities,
    //     @RequestParam("uom[]") List<String> uoms,
    //     Model model
    // ) {


    //     System.out.println(transactionDate);
    //     System.out.println(purpose);
    //     System.out.println(warehouse);
    //     System.out.println(requiredBy);


    //     for (int i = 0; i < itemCodes.size(); i++) {
    //         System.out.println(itemCodes.get(i)+" "+quantities.get(i)+" "+uoms.get(i));
    //     }

    //     // demande de materiel 
    //     // demande de devis


    //     model.addAttribute("page", "dashboard");
    //     return "main-page";
    // }



}
