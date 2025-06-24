package itu.mg.new_app.controller;



import org.springframework.stereotype.Controller;


@Controller
public class Accounting_controller {
    
    final String FILE_PATH = "save_payment.json";
    // ObjectMapper objectMapper = new ObjectMapper();


    // @Autowired Purchase_invoice_service purchase_invoice_service;

    // @GetMapping ("/list/facture")
    // public String liste_facturePage (Model model) {

    //     List <Purchase_invoice> purchase_invoices = purchase_invoice_service.get_all();
    //     // System.out.println(purchase_invoices.size());
    //     model.addAttribute("purchase_invoices", purchase_invoices);
    //     model.addAttribute("page", "list-purchaseInvoice");
    //     return "main-page";
    // }

    // @GetMapping ("/detail/facture")
    // public String detail_facturePage (Model model, @RequestParam("purchase_invoice") String purchase_invoice) {

    //     model.addAttribute("purchase_invoice", purchase_invoice_service.get_By(purchase_invoice));
    //     model.addAttribute("items", purchase_invoice_service.get_ItemPurchaseInvoice_By(purchase_invoice));

    //     model.addAttribute("page", "detail-purchaseInvoice");
    //     return "main-page";
    // }

    
    // @GetMapping ("/paiement")
    // public String payement_page (Model model, @RequestParam("purchase_invoice") String purchase_invoice) {

    //     Payment_entry payment_entry = purchase_invoice_service.payment_entry(purchase_invoice, FILE_PATH);
     
    //     model.addAttribute("payment_entry", payment_entry);

    //     model.addAttribute("page", "paiement-facture");
    //     return "main-page";
    // }

    // @SuppressWarnings("null")
    // @PostMapping("/paiement/sauvgarder")
    // public String save_paiement (@ModelAttribute Payment_entry payment_entry, Model model) {

    //     // System.out.println(payment_entry.getPaid_amount()+" "+payment_entry.getReference_no());
    //     File file = new File(FILE_PATH);
    //     String name1 = Default_service.generateTempName("payment-entry");
    //     String name2 = Default_service.generateTempName("payment-entry-reference");
        
    //     try {
    //         JsonNode rootNode = objectMapper.readTree(file);
    //         JsonNode messageNode = rootNode.get("message");

    //         if (messageNode != null && messageNode.isObject()) {
    //             ObjectNode objectNode = (ObjectNode) messageNode;
            
    //             objectNode.put("paid_amount", payment_entry.getPaid_amount());
    //             objectNode.put("base_paid_amount", payment_entry.getPaid_amount());
    //             objectNode.put("received_amount", payment_entry.getPaid_amount());
    //             objectNode.put("base_received_amount", payment_entry.getPaid_amount());
    //             objectNode.put("total_allocated_amount", payment_entry.getPaid_amount());
    //             objectNode.put("base_total_allocated_amount", payment_entry.getPaid_amount());
    //             objectNode.put("name", name1);
    //             objectNode.put("reference_no", payment_entry.getReference_no());
            
    //             // Modifier "references"
    //             JsonNode ref = messageNode.get("references");
    //             if (ref != null && ref.isArray() && ref.size() > 0) {
    //                 ObjectNode firstReference = (ObjectNode) ref.get(0);
    //                 firstReference.put("allocated_amount", payment_entry.getPaid_amount());
    //                 firstReference.put("parent", name1);
    //                 firstReference.put("name", name2);
    //             }
    //         }
            
    //         objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
            
    //         String submit_doc = purchase_invoice_service.Save_paiement(messageNode.toString());
            
    //         // file.delete(); // supprimer le fichier contenant les données JSON
            
    //         rootNode = objectMapper.readTree(submit_doc);
    //         JsonNode doc = rootNode.get("docs").get(0);
    //         ObjectNode Odoc = (ObjectNode) doc;

    //         Odoc.remove("localname");
    //         Odoc.put("__last_sync_on", Instant.now().toString());
        
    //         purchase_invoice_service.Valider_paiement(doc.toString());
    //         // System.out.println(doc.toPrettyString());
            
    //         file.delete(); // supprimer le fichier **************
    //         model.addAttribute("page", "valider-paiement");
    //         return "redirect:/list/facture";

    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     return null;
        
    // }


}
