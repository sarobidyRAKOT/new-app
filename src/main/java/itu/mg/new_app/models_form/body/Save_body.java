package itu.mg.new_app.models_form.body;

public class Save_body {
    private String doc;
    private String action;

    public Save_body () {}

    public String getDoc() {
        return doc;
    }
    public String getAction() {
        return action;
    }


    public void setAction(String action) {
        this.action = action;
    }
    public void setDoc(String doc) {
        this.doc = doc;
    }
}
