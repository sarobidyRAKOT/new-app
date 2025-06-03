package itu.mg.new_app.model.supplier;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Supplier {

    private String name;
    private String supplier_name;
    private String supplier_group;
    private String tax_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;


    public Supplier () {}


    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSupplier_name() { return supplier_name; }
    public void setSupplier_name(String supplier_name) { this.supplier_name = supplier_name; }

    public String getTax_id() { return tax_id; }
    public void setTax_id(String tax_id) { this.tax_id = tax_id; }
    public LocalDateTime getCreation() { return creation; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }

    public String getSupplier_group() { return supplier_group; }
    public void setSupplier_group(String supplier_group) { this.supplier_group = supplier_group; }
}
