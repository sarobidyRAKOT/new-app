package itu.mg.new_app.model.supplier;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Request_forQuotation {

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate transaction_date;
    private BigDecimal grand_total;
    private String status;
    private String supplier;

    public Request_forQuotation () {}
    
    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getTransaction_date() { return transaction_date; }
    public void setTransaction_date(LocalDate transaction_date) { this.transaction_date = transaction_date; }
    public BigDecimal getGrand_total() { return grand_total; }
    public void setGrand_total(BigDecimal grand_total) { this.grand_total = grand_total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
}


