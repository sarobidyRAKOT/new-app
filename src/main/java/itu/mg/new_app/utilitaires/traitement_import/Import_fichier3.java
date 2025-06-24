package itu.mg.new_app.utilitaires.traitement_import;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import itu.mg.new_app.model.body.*;
import itu.mg.new_app.utilitaires.result_import.*;

public class Import_fichier3 implements ImportExport_impl <Fichier_3> {

    private final Fichier_3 fichier_3 = new Fichier_3 ();

    @Override
    public void Import (String[] ligne, int num_ligne) {

        if (ligne.length == 4) {
            // Traitement ...

            LocalDate from_date = parseDate(ligne[0]);
            Integer ref = Integer.parseInt(ligne[1]);
            double base = Double.valueOf(ligne[2]);
            String salary_structure = ligne[3];

            Salary_Structure_Assignment_body ssaB = new Salary_Structure_Assignment_body(from_date, ""+ref, base, salary_structure);
            Salary_Slip_body ssB = new Salary_Slip_body();

            fichier_3.addSalary_Slip(ssB);
            fichier_3.addSalary_StructureAssignment(ssaB);

        } else fichier_3.addErrors ("Nombre de colonne invalide a la ligne "+num_ligne);
    }
    

    @Override
    public List<String> Export(List<Fichier_3> objets) {
        throw new UnsupportedOperationException("Unimplemented method 'Export'");
    }


    public LocalDate parseDate (String input) {
        String[] patterns = {
            "yyyy-MM-dd", "dd/MM/yyyy", "MM-dd-yyyy",
            "MMMM d, yyyy", "yyyy.MM.dd"
        };

        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                return LocalDate.parse(input, formatter);
            } catch (Exception ignored) {}
        }

        throw new IllegalArgumentException("Format de date non reconnu : " + input);
    }    


	@Override
	public Fichier_3 get_result() {
        return this.fichier_3;
    }

    
}

