package itu.mg.new_app.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment_entry {

    private String naming_series;
    private String payment_type;
    @JsonFormat(pattern = "yyyy-MM-dd") 
    private LocalDate posting_date;
    private String company;     
    private String party_type;
    private String party;
    private String party_name;
    private Double paid_amount;
    private String reference_no;

    private String reference_name; // id facture

    public String getReference_name() {
        return reference_name;
    }
    public void setReference_name(String reference_name) {
        this.reference_name = reference_name;
    }

    // Getters et Setters

    public String getCompany() { return company;}
    public String getNaming_series() { return naming_series;}
    public Double getPaid_amount() { return paid_amount;}
    public String getParty() { return party;}
    public String getParty_name() { return party_name;}
    public String getParty_type() { return party_type;}
    public String getPayment_type() { return payment_type;}
    public LocalDate getPosting_date() { return posting_date;}
    public String getReference_no() { return reference_no;}

    public void setCompany(String company) { this.company = company;}
    public void setNaming_series(String naming_series) { this.naming_series = naming_series;}
    public void setPaid_amount(Double paid_amount) { this.paid_amount = paid_amount;}
    public void setParty(String party) { this.party = party;}
    public void setParty_name(String party_name) { this.party_name = party_name;}
    public void setParty_type(String party_type) { this.party_type = party_type;}
    public void setPayment_type(String payment_type) { this.payment_type = payment_type;}
    public void setPosting_date(LocalDate posting_date) { this.posting_date = posting_date;}
    public void setReference_no(String reference_no) { this.reference_no = reference_no;}
}
    
