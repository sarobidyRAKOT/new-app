package itu.mg.new_app.models_form;

public class Filtre_Mois_form {
    
    private int mois;
    private int annees;


    public Filtre_Mois_form () {}
    
    public int getAnnees() { return annees; }
    public int getMois() { return mois; }
    public void setAnnees(int annees) { this.annees = annees; }
    public void setMois(int mois) { this.mois = mois; }


    public boolean validForm () {
        if (this.annees >= 1960 && this.mois > 0) {
            return true;
        }
        return false;
    }
}
