package itu.mg.new_app.model;

public class User {
    
    private String full_name;

    public User (String full_name) {
        this.setFull_name(full_name);
    }

    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
