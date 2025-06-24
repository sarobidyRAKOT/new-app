package itu.mg.new_app.utilitaires.traitement_import;

import java.util.*;

import itu.mg.new_app.model.body.*;
import itu.mg.new_app.utilitaires.result_import.Fichier_2;

public class Import_fichier2 implements ImportExport_impl <Fichier_2> {


    private final Fichier_2 fichier_2 = new Fichier_2 ();

    @Override
    public void Import (String[] ligne, int num_ligne) {
        if (ligne.length == 6) {
            // Traitement ...
            String salary_structure = ligne[0];
            String salary_component = ligne[1];
            String abbr = ligne[2];
            String type = this.capitalizeFirstLetter(ligne[3]);
            String fourmula = ligne[4];
            String company = ligne[5];

            fichier_2.addSalary_Component_bodies(new Salary_Component_body(salary_component, abbr, type, fourmula));
            Salary_Structure_body new_ssB = new Salary_Structure_body(salary_structure, company, type, salary_component, fourmula);

            Optional<Salary_Structure_body> existing_ssb = fichier_2.getSalary_Structure_bodies().stream()
                .filter(s -> s.equals(new_ssB)).findFirst();
            if (existing_ssb.isPresent()) {
                existing_ssb.get().add_Salary_Detail(type, salary_component, fourmula);
            } else {
                fichier_2.addSalary_Structure_bodies(new_ssB);
            }

        } else fichier_2.addErrors ("Nombre de colonne invalide a la ligne "+num_ligne);
    }

    @Override
    public List<String> Export(List<Fichier_2> objets) {
        throw new UnsupportedOperationException("Unimplemented method 'Export'");
    }



    private  String capitalizeFirstLetter (String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase(); // ou sans toLowerCase() si tu veux garder le reste tel quel
    }

    @Override
    public Fichier_2 get_result() {
        return this.fichier_2;
    }
}

