package itu.mg.new_app.model.form;

import java.time.LocalDate;
import java.util.List;

public class Material_Request_form {
    
    private LocalDate transaction_date;
    private String purpose;
    private String warehouse;
    private LocalDate required_by;
    private List <Item_MR> items;

    public Material_Request_form () {}

    public List<Item_MR> getItems() { return items; }
    public String getPurpose() { return purpose; }
    public LocalDate getRequired_by() { return required_by; }
    public LocalDate getTransaction_date() { return transaction_date; }
    public String getWarehouse() { return warehouse; }

    public void setItems(List<Item_MR> items) { this.items = items; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public void setRequired_by(LocalDate required_by) { this.required_by = required_by; }
    public void setTransaction_date(LocalDate transaction_date) { this.transaction_date = transaction_date; }
    public void setWarehouse(String warehouse) { this.warehouse = warehouse; }

    public void print_items () {
        for (Item_MR item_MR : items) {
            System.out.println(item_MR.toString());
        }
    }
}

class Item_MR {
    private String item_name;
    private int qty;
    private String uom;

    public Item_MR () {}

    public String getItem_name() { return item_name; }
    public int getQty() { return qty; }
    public String getUom() { return uom; }
    public void setItem_name(String item_name) { this.item_name = item_name; }
    public void setQty(int qty) { this.qty = qty; }
    public void setUom(String uom) { this.uom = uom; }

    @Override
    public String toString() {
        return item_name+" "+qty+" "+uom;
    }
}
