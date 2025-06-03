package itu.mg.new_app.service.supplier;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import itu.mg.new_app.model.supplier.Purchase_order;
import itu.mg.new_app.models_form.body.List_body;
import itu.mg.new_app.service.API_Service;

// COMMANDE FOURNISSEUR *****

@Service
public class PurchaseOrder_service {
    
    @Autowired private API_Service api_Service;
    
    public List <Purchase_order> get_all (String supplierName) {
        
        List_body body = new List_body();
        HashMap<String, Object> filtre = new HashMap<>();
        filtre.put("supplier", supplierName);
        body.setDoctype("Purchase Order");
        body.setFields(Arrays.asList(
            "name","owner","creation","modified","modified_by","_user_tags",
            "_comments","_assign","_liked_by","docstatus","idx","transaction_date",
            "total","net_total","tax_withholding_net_total","taxes_and_charges_added",
            "taxes_and_charges_deducted","total_taxes_and_charges", "grand_total",
            "rounding_adjustment","rounded_total","advance_paid","discount_amount",
            "status","per_billed","per_received","supplier_name","base_grand_total","company",
            "currency","supplier","advance_payment_status","party_account_currency"
        ));
        body.setFilters(filtre);
        body.setOrder_by("creation desc");

        Purchase_orderList purchase_orderList = api_Service.API_List(body, null, HttpMethod.POST, new ParameterizedTypeReference<Purchase_orderList>() {});
        
        return purchase_orderList.getMessage();
    }
    

    

}

class Purchase_orderList {

    private List <Purchase_order> message;
    public Purchase_orderList () {}
    public void setMessage(List<Purchase_order> message) { this.message = message; }
    public List<Purchase_order> getMessage() { return message; }
    
}
