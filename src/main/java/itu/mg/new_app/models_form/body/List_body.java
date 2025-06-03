package itu.mg.new_app.models_form.body;

import java.util.HashMap;
import java.util.List;

public class List_body {
    
    private String doctype;
    private List <String> fields;
    private HashMap <String, Object> filters;
    private String order_by;

    public List_body () {}

    public String getOrder_by() {
        return order_by;
    }
    public void setOrder_by(String order_by) {
        this.order_by = order_by;
    }
    public HashMap<String, Object> getFilters() { return filters; }
    public void setFilters(HashMap<String, Object> filters) { this.filters = filters; }
    public String getDoctype() { return doctype; }
    public List<String> getFields() { return fields; }
    public void setDoctype(String doctype) { this.doctype = doctype; }
    public void setFields(List<String> fields) { this.fields = fields; }
}
