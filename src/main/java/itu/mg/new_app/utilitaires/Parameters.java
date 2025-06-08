package itu.mg.new_app.utilitaires;

import java.util.*;

public class Parameters {
    
    /**
     * fields -> order, fields, limit
     * filter -> contient (field, operator, value)
     * rmq filter: (objet date tsy maintsy atao String pour value)
     */

    Map <String, Object> fields = new HashMap<>();
    List <List <Object>> filters = new ArrayList<>();

    private Parameters () {}
    public static Parameters get_instance () {
        return new Parameters();
    }

    public Map<String, Object> getFields() { return fields; }
    public List<List<Object>> getFilters() { return filters; }

    public void filters_RemoveAll () {
        this.filters.clear();
    }
    public void remove_filter (String field, String operator, Object value) {
        this.filters.remove(List.of(field, operator, value));
    }

    public void fields_RemoveAll () {
        this.fields.clear();
    }

    public void addField(String key, Object value) {
        this.fields.put(key, value);
    }
    public void addFilter(String field, String operator, Object value) {
        this.filters.add(Arrays.asList(field, operator, value));
    }

    

}
