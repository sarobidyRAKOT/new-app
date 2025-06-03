package itu.mg.new_app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Purchase_invoice {

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
    private LocalDate posting_date;

    private double total;
    private double net_total;
    private double tax_withholding_net_total;
    private double taxes_and_charges_added;
    private double taxes_and_charges_deducted;
    private double total_taxes_and_charges;
    private double grand_total;
    private double rounding_adjustment;
    private double rounded_total;
    private double total_advance;
    private double outstanding_amount;
    private double discount_amount;
    private double paid_amount;
    private double write_off_amount;

    private String status;
    private String title;
    private String supplier;
    private String supplier_name;
    private double base_grand_total;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate due_date;

    private String company;
    private String currency;
    private int is_return;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate release_date;

    private int on_hold;
    private String represents_company;
    private int is_internal_supplier;
    private String party_account_currency;
    private int _comment_count;


    public static Purchase_invoice jsonToPurchaseInvoice(List<String> keys, JsonNode row, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateFormatter) {

        Purchase_invoice pi = new Purchase_invoice();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            JsonNode value = row.get(i);

            switch (key) {
                case "name": pi.setName(value.asText()); break;
                case "owner": pi.setOwner(value.asText()); break;

                case "creation":
                    if (!value.isNull()) pi.setCreation(LocalDateTime.parse(value.asText(), dateTimeFormatter));
                    break;

                case "modified":
                    if (!value.isNull()) pi.setModified(LocalDateTime.parse(value.asText(), dateTimeFormatter));
                    break;

                case "modified_by": pi.setModified_by(getTextOrNull(value)); break;
                case "_user_tags": pi.set_user_tags(getTextOrNull(value)); break;
                case "_comments": pi.set_comments(getTextOrNull(value)); break;
                case "_assign": pi.set_assign(getTextOrNull(value)); break;
                case "_liked_by": pi.set_liked_by(getTextOrNull(value)); break;

                case "docstatus": pi.setDocstatus(value.asInt()); break;
                case "idx": pi.setIdx(value.asInt()); break;

                case "posting_date":
                    if (!value.isNull()) pi.setPosting_date(LocalDate.parse(value.asText(), dateFormatter));
                    break;

                case "total": pi.setTotal(value.asDouble()); break;
                case "net_total": pi.setNet_total(value.asDouble()); break;
                case "tax_withholding_net_total": pi.setTax_withholding_net_total(value.asDouble()); break;
                case "taxes_and_charges_added": pi.setTaxes_and_charges_added(value.asDouble()); break;
                case "taxes_and_charges_deducted": pi.setTaxes_and_charges_deducted(value.asDouble()); break;
                case "total_taxes_and_charges": pi.setTotal_taxes_and_charges(value.asDouble()); break;
                case "grand_total": pi.setGrand_total(value.asDouble()); break;
                case "rounding_adjustment": pi.setRounding_adjustment(value.asDouble()); break;
                case "rounded_total": pi.setRounded_total(value.asDouble()); break;
                case "total_advance": pi.setTotal_advance(value.asDouble()); break;
                case "outstanding_amount": pi.setOutstanding_amount(value.asDouble()); break;
                case "discount_amount": pi.setDiscount_amount(value.asDouble()); break;
                case "paid_amount": pi.setPaid_amount(value.asDouble()); break;
                case "write_off_amount": pi.setWrite_off_amount(value.asDouble()); break;

                case "status": pi.setStatus(value.asText()); break;
                case "title": pi.setTitle(value.asText()); break;
                case "supplier": pi.setSupplier(value.asText()); break;
                case "supplier_name": pi.setSupplier_name(value.asText()); break;
                case "base_grand_total": pi.setBase_grand_total(value.asDouble()); break;

                case "due_date":
                    if (!value.isNull()) pi.setDue_date(LocalDate.parse(value.asText(), dateFormatter));
                    break;

                case "company": pi.setCompany(value.asText()); break;
                case "currency": pi.setCurrency(value.asText()); break;
                case "is_return": pi.setIs_return(value.asInt()); break;

                case "release_date":
                    if (!value.isNull()) pi.setRelease_date(LocalDate.parse(value.asText(), dateFormatter));
                    break;

                case "on_hold": pi.setOn_hold(value.asInt()); break;
                case "represents_company": pi.setRepresents_company(getTextOrNull(value)); break;
                case "is_internal_supplier": pi.setIs_internal_supplier(value.asInt()); break;
                case "party_account_currency": pi.setParty_account_currency(value.asText()); break;
                case "_comment_count": pi.set_comment_count(value.asInt()); break;
            }
        }

        return pi;
    }

    
    private static String getTextOrNull(JsonNode node) {
        return node.isNull() ? null : node.asText();
    }


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

    public LocalDate getPosting_date() { return posting_date; }
    public void setPosting_date(LocalDate posting_date) { this.posting_date = posting_date; }

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

    public double getTotal_advance() { return total_advance; }
    public void setTotal_advance(double total_advance) { this.total_advance = total_advance; }

    public double getOutstanding_amount() { return outstanding_amount; }
    public void setOutstanding_amount(double outstanding_amount) { this.outstanding_amount = outstanding_amount; }

    public double getDiscount_amount() { return discount_amount; }
    public void setDiscount_amount(double discount_amount) { this.discount_amount = discount_amount; }

    public double getPaid_amount() { return paid_amount; }
    public void setPaid_amount(double paid_amount) { this.paid_amount = paid_amount; }

    public double getWrite_off_amount() { return write_off_amount; }
    public void setWrite_off_amount(double write_off_amount) { this.write_off_amount = write_off_amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public String getSupplier_name() { return supplier_name; }
    public void setSupplier_name(String supplier_name) { this.supplier_name = supplier_name; }

    public double getBase_grand_total() { return base_grand_total; }
    public void setBase_grand_total(double base_grand_total) { this.base_grand_total = base_grand_total; }

    public LocalDate getDue_date() { return due_date; }
    public void setDue_date(LocalDate due_date) { this.due_date = due_date; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public int getIs_return() { return is_return; }
    public void setIs_return(int is_return) { this.is_return = is_return; }

    public LocalDate getRelease_date() { return release_date; }
    public void setRelease_date(LocalDate release_date) { this.release_date = release_date; }

    public int getOn_hold() { return on_hold; }
    public void setOn_hold(int on_hold) { this.on_hold = on_hold; }

    public String getRepresents_company() { return represents_company; }
    public void setRepresents_company(String represents_company) { this.represents_company = represents_company; }

    public int getIs_internal_supplier() { return is_internal_supplier; }
    public void setIs_internal_supplier(int is_internal_supplier) { this.is_internal_supplier = is_internal_supplier; }

    public String getParty_account_currency() { return party_account_currency; }
    public void setParty_account_currency(String party_account_currency) { this.party_account_currency = party_account_currency; }

    public int get_comment_count() { return _comment_count; }
    public void set_comment_count(int _comment_count) { this._comment_count = _comment_count; }
}
