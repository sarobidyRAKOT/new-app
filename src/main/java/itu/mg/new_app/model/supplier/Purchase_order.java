package itu.mg.new_app.model.supplier;

import java.time.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Purchase_order {

    private String name;
    private String owner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;
    private String modified_by;
    private String _user_tags;
    private String _comments;
    private String _assign;
    private String _liked_by;
    private int docstatus;
    private int idx;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate transaction_date;
    private double total;
    private double net_total;
    private double tax_withholding_net_total;
    private double taxes_and_charges_added;
    private double taxes_and_charges_deducted;
    private double total_taxes_and_charges;
    private double grand_total;
    private double rounding_adjustment;
    private double rounded_total;
    private double advance_paid;
    private double discount_amount;
    private String status;
    private double per_billed;  // corrigé
    private double per_received;  // corrigé
    private String supplier_name;
    private double base_grand_total;
    private String company;
    private String currency;
    private String supplier;
    private String advance_payment_status;
    private String party_account_currency;
    private int _comment_count;


    // JSON TO PURCHASE *************
    public Purchase_order () {}
    // ----------- Getters and Setters -----------

    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    
    public LocalDateTime getCreation() { return creation; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }
    
    public LocalDateTime getModified() { return modified; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }
    
    public String getModified_by() { return modified_by; }
    public void setModified_by(String modified_by) { this.modified_by = modified_by; }
    
    public String get_user_tags() { return _user_tags; }
    public void set_user_tags(String _user_tags) { this._user_tags = _user_tags; }
    
    public String get_comments() { return _comments; }
    public void set_comments(String _comments) { this._comments = _comments; }
    
    public String get_assign() { return _assign; }
    public void set_assign(String _assign) { this._assign = _assign; }
    
    public String get_liked_by() { return _liked_by; }
    public void set_liked_by(String _liked_by) { this._liked_by = _liked_by; }
    
    public int getDocstatus() { return docstatus; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    
    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }
    
    public LocalDate getTransaction_date() { return transaction_date; }
    public void setTransaction_date(LocalDate transaction_date) { this.transaction_date = transaction_date; }
    
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    
    public double getNet_total() { return net_total; }
    public void setNet_total(double net_total) { this.net_total = net_total; }
    
    public double getTax_withholding_net_total() { return tax_withholding_net_total; }
    public void setTax_withholding_net_total(double tax_withholding_net_total) { this.tax_withholding_net_total = tax_withholding_net_total; }
    
    public double getTaxes_and_charges_added() { return taxes_and_charges_added; }
    public void setTaxes_and_charges_added(double taxes_and_charges_added) { this.taxes_and_charges_added = taxes_and_charges_added; }
    
    public double getTaxes_and_charges_deducted() { return taxes_and_charges_deducted; }
    public void setTaxes_and_charges_deducted(double taxes_and_charges_deducted) { this.taxes_and_charges_deducted = taxes_and_charges_deducted; }
    
    public double getTotal_taxes_and_charges() { return total_taxes_and_charges; }
    public void setTotal_taxes_and_charges(double total_taxes_and_charges) { this.total_taxes_and_charges = total_taxes_and_charges; }
    
    public double getGrand_total() { return grand_total; }
    public void setGrand_total(double grand_total) { this.grand_total = grand_total; }
    
    public double getRounding_adjustment() { return rounding_adjustment; }
    public void setRounding_adjustment(double rounding_adjustment) { this.rounding_adjustment = rounding_adjustment; }
    
    public double getRounded_total() { return rounded_total; }
    public void setRounded_total(double rounded_total) { this.rounded_total = rounded_total; }
    
    public double getAdvance_paid() { return advance_paid; }
    public void setAdvance_paid(double advance_paid) { this.advance_paid = advance_paid; }
    
    public double getDiscount_amount() { return discount_amount; }
    public void setDiscount_amount(double discount_amount) { this.discount_amount = discount_amount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public double getPer_billed() { return per_billed; }
    public void setPer_billed(double per_billed) { this.per_billed = per_billed; }
    
    public double getPer_received() { return per_received; }
    public void setPer_received(double per_received) { this.per_received = per_received; }
    
    public String getSupplier_name() { return supplier_name; }
    public void setSupplier_name(String supplier_name) { this.supplier_name = supplier_name; }
    
    public double getBase_grand_total() { return base_grand_total; }
    public void setBase_grand_total(double base_grand_total) { this.base_grand_total = base_grand_total; }
    
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    
    public String getAdvance_payment_status() { return advance_payment_status; }
    public void setAdvance_payment_status(String advance_payment_status) { this.advance_payment_status = advance_payment_status; }
    
    public String getParty_account_currency() { return party_account_currency; }
    public void setParty_account_currency(String party_account_currency) { this.party_account_currency = party_account_currency; }
    
    public int get_comment_count() { return _comment_count; }
    public void set_comment_count(int _comment_count) { this._comment_count = _comment_count; }


}
