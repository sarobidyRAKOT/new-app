package itu.mg.new_app.utilitaires.traitement;

import java.util.List;
import java.util.Map;

import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.models_form.imports_value.Fichier_2;
import itu.mg.new_app.utilitaires.ImportExport_impl;

public class Import_fichier2 implements ImportExport_impl <Fichier_2> {



    @Override
    public Fichier_2 Import (String[] ligne, int num_ligne) throws Exception {

        if (ligne.length == 6) {
            // Traitement ...
            String salary_structure = ligne[0];
            String name = ligne[1];
            String abbr = ligne[2];
            String type = this.capitalizeFirstLetter(ligne[3]);
            String fourmula = ligne[4];
            String company = ligne[5];

            
            Salary_Component_body scBody = new Salary_Component_body(name, abbr, type, fourmula);
            Salary_Structure_body ssBody = new Salary_Structure_body(salary_structure, company, type, abbr, fourmula); 
            
            return new Fichier_2(scBody, ssBody);

        } else throw new Exception("Nombre de colonne invalide !!");
    }

    @Override
    public List<String> Export(List<Fichier_2> objets) {
        throw new UnsupportedOperationException("Unimplemented method 'Export'");
    }


    @Override
    public String translate(Map<String, String> data, String input) {
        throw new UnsupportedOperationException("Unimplemented method 'Export'");
    }
    
    @Override
    public String generateTempName(String doctype) {
        throw new UnsupportedOperationException("Unimplemented method 'Export'");
    }

    @Override
    public String abbreviate(String input) {
        throw new UnsupportedOperationException("Unimplemented method 'abbreviate'");
    }

    private  String capitalizeFirstLetter (String input) {
    if (input == null || input.isEmpty()) {
        return input;
    }
    return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase(); // ou sans toLowerCase() si tu veux garder le reste tel quel
}
}

