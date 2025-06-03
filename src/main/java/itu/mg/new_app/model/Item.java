package itu.mg.new_app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

public class Item {
    
    private String name;
    private String owner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") 
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") 
    private LocalDateTime modified;
    private String modified_by;
    private int docstatus;
    private int idx;
    private String item_code;
    private String item_name;
    private String description;
    private String item_group;
    private String image;
    private double received_qty;
    private double qty;
    private double rejected_qty;
    private String uom;
    private double conversion_factor;
    private String stock_uom;
    private double stock_qty;
    private double price_list_rate;
    private double base_price_list_rate;
    private String margin_type;
    private double margin_rate_or_amount;
    private double rate_with_margin;
    private double discount_percentage;
    private double discount_amount;
    private double distributed_discount_amount;
    private double base_rate_with_margin;
    private double rate;
    private double amount;
    private double base_rate;
    private double base_amount;
    private double stock_uom_rate;
    private int is_free_item;
    private int apply_tds;
    private double net_rate;
    private double net_amount;
    private double base_net_rate;
    private double base_net_amount;
    private double valuation_rate;
    private double sales_incoming_rate;
    private double item_tax_amount;
    private double landed_cost_voucher_amount;
    private double rm_supp_cost;
    private String warehouse;
    private int use_serial_batch_fields;
    private String expense_account;
    private int is_fixed_asset;
    private int enable_deferred_expense;
    private int allow_zero_valuation_rate;
    private String item_tax_rate;
    private int include_exploded_items;
    private String purchase_order;
    private String po_detail;
    private double weight_per_unit;
    private double total_weight;
    private String cost_center;
    private int page_break;
    private String parent;
    private String parentfield;
    private String parenttype;
    private String doctype;

    
    public static Item jsonToItem (List<String> keys, JsonNode row, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateFormatter) {


        Item item = new Item();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            JsonNode value = row.get(i);

            switch (key) {
                case "name": item.setName(value.asText()); break;
                case "owner": item.setOwner(value.asText()); break;
                case "creation": if (!value.isNull()) item.setCreation(LocalDateTime.parse(value.asText(), dateTimeFormatter)); break;
                case "modified": if (!value.isNull()) item.setModified(LocalDateTime.parse(value.asText(), dateTimeFormatter)); break;
                case "modified_by": item.setModified_by(getTextOrNull(value)); break;
                case "docstatus": item.setDocstatus(value.asInt()); break;
                case "idx": item.setIdx(value.asInt()); break;
                case "item_code": item.setItem_code(value.asText()); break;
            }
        }

        return item;
    }

    
    private static String getTextOrNull(JsonNode node) {
        return node.isNull() ? null : node.asText();
    }

    // Getters & Setters (générer avec IDE ou Lombok si tu veux)

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

    public int getDocstatus() { return docstatus; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }

    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }

    public String getItem_code() { return item_code; }
    public void setItem_code(String item_code) { this.item_code = item_code; }

    public String getItem_name() { return item_name; }
    public void setItem_name(String item_name) { this.item_name = item_name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getItem_group() { return item_group; }
    public void setItem_group(String item_group) { this.item_group = item_group; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public double getReceived_qty() { return received_qty; }
    public void setReceived_qty(double received_qty) { this.received_qty = received_qty; }

    public double getQty() { return qty; }
    public void setQty(double qty) { this.qty = qty; }

    public double getRejected_qty() { return rejected_qty; }
    public void setRejected_qty(double rejected_qty) { this.rejected_qty = rejected_qty; }

    public String getUom() { return uom; }
    public void setUom(String uom) { this.uom = uom; }

    public double getConversion_factor() { return conversion_factor; }
    public void setConversion_factor(double conversion_factor) { this.conversion_factor = conversion_factor; }

    public String getStock_uom() { return stock_uom; }
    public void setStock_uom(String stock_uom) { this.stock_uom = stock_uom; }

    public double getStock_qty() { return stock_qty; }
    public void setStock_qty(double stock_qty) { this.stock_qty = stock_qty; }

    public double getPrice_list_rate() { return price_list_rate; }
    public void setPrice_list_rate(double price_list_rate) { this.price_list_rate = price_list_rate; }

    public double getBase_price_list_rate() { return base_price_list_rate; }
    public void setBase_price_list_rate(double base_price_list_rate) { this.base_price_list_rate = base_price_list_rate; }

    public String getMargin_type() { return margin_type; }
    public void setMargin_type(String margin_type) { this.margin_type = margin_type; }

    public double getMargin_rate_or_amount() { return margin_rate_or_amount; }
    public void setMargin_rate_or_amount(double margin_rate_or_amount) { this.margin_rate_or_amount = margin_rate_or_amount; }

    public double getRate_with_margin() { return rate_with_margin; }
    public void setRate_with_margin(double rate_with_margin) { this.rate_with_margin = rate_with_margin; }

    public double getDiscount_percentage() { return discount_percentage; }
    public void setDiscount_percentage(double discount_percentage) { this.discount_percentage = discount_percentage; }

    public double getDiscount_amount() { return discount_amount; }
    public void setDiscount_amount(double discount_amount) { this.discount_amount = discount_amount; }

    public double getDistributed_discount_amount() { return distributed_discount_amount; }
    public void setDistributed_discount_amount(double distributed_discount_amount) { this.distributed_discount_amount = distributed_discount_amount; }

    public double getBase_rate_with_margin() { return base_rate_with_margin; }
    public void setBase_rate_with_margin(double base_rate_with_margin) { this.base_rate_with_margin = base_rate_with_margin; }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getBase_rate() { return base_rate; }
    public void setBase_rate(double base_rate) { this.base_rate = base_rate; }

    public double getBase_amount() { return base_amount; }
    public void setBase_amount(double base_amount) { this.base_amount = base_amount; }

    public double getStock_uom_rate() { return stock_uom_rate; }
    public void setStock_uom_rate(double stock_uom_rate) { this.stock_uom_rate = stock_uom_rate; }

    public int getIs_free_item() { return is_free_item; }
    public void setIs_free_item(int is_free_item) { this.is_free_item = is_free_item; }

    public int getApply_tds() { return apply_tds; }
    public void setApply_tds(int apply_tds) { this.apply_tds = apply_tds; }

    public double getNet_rate() { return net_rate; }
    public void setNet_rate(double net_rate) { this.net_rate = net_rate; }

    public double getNet_amount() { return net_amount; }
    public void setNet_amount(double net_amount) { this.net_amount = net_amount; }

    public double getBase_net_rate() { return base_net_rate; }
    public void setBase_net_rate(double base_net_rate) { this.base_net_rate = base_net_rate; }

    public double getBase_net_amount() { return base_net_amount; }
    public void setBase_net_amount(double base_net_amount) { this.base_net_amount = base_net_amount; }

    public double getValuation_rate() { return valuation_rate; }
    public void setValuation_rate(double valuation_rate) { this.valuation_rate = valuation_rate; }

    public double getSales_incoming_rate() { return sales_incoming_rate; }
    public void setSales_incoming_rate(double sales_incoming_rate) { this.sales_incoming_rate = sales_incoming_rate; }

    public double getItem_tax_amount() { return item_tax_amount; }
    public void setItem_tax_amount(double item_tax_amount) { this.item_tax_amount = item_tax_amount; }

    public double getLanded_cost_voucher_amount() { return landed_cost_voucher_amount; }
    public void setLanded_cost_voucher_amount(double landed_cost_voucher_amount) { this.landed_cost_voucher_amount = landed_cost_voucher_amount; }

    public double getRm_supp_cost() { return rm_supp_cost; }
    public void setRm_supp_cost(double rm_supp_cost) { this.rm_supp_cost = rm_supp_cost; }

    public String getWarehouse() { return warehouse; }
    public void setWarehouse(String warehouse) { this.warehouse = warehouse; }

    public int getUse_serial_batch_fields() { return use_serial_batch_fields; }
    public void setUse_serial_batch_fields(int use_serial_batch_fields) { this.use_serial_batch_fields = use_serial_batch_fields; }

    public String getExpense_account() { return expense_account; }
    public void setExpense_account(String expense_account) { this.expense_account = expense_account; }

    public int getIs_fixed_asset() { return is_fixed_asset; }
    public void setIs_fixed_asset(int is_fixed_asset) { this.is_fixed_asset = is_fixed_asset; }

    public int getEnable_deferred_expense() { return enable_deferred_expense; }
    public void setEnable_deferred_expense(int enable_deferred_expense) { this.enable_deferred_expense = enable_deferred_expense; }

    public int getAllow_zero_valuation_rate() { return allow_zero_valuation_rate; }
    public void setAllow_zero_valuation_rate(int allow_zero_valuation_rate) { this.allow_zero_valuation_rate = allow_zero_valuation_rate; }

    public String getItem_tax_rate() { return item_tax_rate; }
    public void setItem_tax_rate(String item_tax_rate) { this.item_tax_rate = item_tax_rate; }

    public int getInclude_exploded_items() { return include_exploded_items; }
    public void setInclude_exploded_items(int include_exploded_items) { this.include_exploded_items = include_exploded_items; }

    public String getPurchase_order() { return purchase_order; }
    public void setPurchase_order(String purchase_order) { this.purchase_order = purchase_order; }

    public String getPo_detail() { return po_detail; }
    public void setPo_detail(String po_detail) { this.po_detail = po_detail; }

    public double getWeight_per_unit() { return weight_per_unit; }
    public void setWeight_per_unit(double weight_per_unit) { this.weight_per_unit = weight_per_unit; }

    public double getTotal_weight() { return total_weight; }
    public void setTotal_weight(double total_weight) { this.total_weight = total_weight; }

    public String getCost_center() { return cost_center; }
    public void setCost_center(String cost_center) { this.cost_center = cost_center; }

    public int getPage_break() { return page_break; }
    public void setPage_break(int page_break) { this.page_break = page_break; }

    public String getParent() { return parent; }
    public void setParent(String parent) { this.parent = parent; }

    public String getParentfield() { return parentfield; }
    public void setParentfield(String parentfield) { this.parentfield = parentfield; }

    public String getParenttype() { return parenttype; }
    public void setParenttype(String parenttype) { this.parenttype = parenttype; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }
}
