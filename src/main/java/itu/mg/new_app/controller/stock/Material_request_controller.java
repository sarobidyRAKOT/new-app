package itu.mg.new_app.controller.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import itu.mg.new_app.model.Utils.Warehouse;
import itu.mg.new_app.model.form.Material_Request_form;
import itu.mg.new_app.model.stock.Item;
import itu.mg.new_app.service.stock.Item_service;
import itu.mg.new_app.service.utils.Warehouse_service;
import itu.mg.new_app.utilitaires.others.*;

@Controller
public class Material_request_controller {
    
    @Autowired private Warehouse_service warehouse_service;
    @Autowired private Item_service item_service;

    @GetMapping ("/form/material-request")
    public String page_formMaterial_Request (Model model) {

        Parameters parameters = Parameters.get_instance(); // 
        parameters.addField("fields", "[\"*\"]");
        List <Warehouse> warehouses = warehouse_service.get_allWith(parameters);
        List <Item> items = item_service.get_allWith(parameters);



        model.addAttribute("material_request_form", new Material_Request_form());
        model.addAttribute("items", items);
        model.addAttribute("warehouses", warehouses);
        model.addAttribute("page", "stock/material-request-FORM");
        return "main-page";
    }


    @PostMapping ("/form/material-request")
    public String formMaterial_Request (@ModelAttribute Material_Request_form material_Request_form, Model model) {

        // Parameters parameters = Parameters.get_instance(); // 
        // parameters.addField("fields", "[\"*\"]");
        // List <Warehouse> warehouses = warehouse_service.get_allWith(parameters);
        // List <Item> items = item_service.get_allWith(parameters);

        System.out.println(material_Request_form.getTransaction_date()+" ");
        material_Request_form.print_items();
                
        // model.addAttribute("items", items);
        // model.addAttribute("warehouses", warehouses);
        // model.addAttribute("page", "stock/material-request-FORM");
        return "redirect:/form/material-request";
    }
    
}
