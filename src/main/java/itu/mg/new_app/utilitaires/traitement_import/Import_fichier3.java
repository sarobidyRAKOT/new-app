package itu.mg.new_app.utilitaires.traitement_import;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.models_form.imports_value.Fichier_3;
import itu.mg.new_app.utilitaires.ImportExport_impl;

public class Import_fichier3 implements ImportExport_impl <Fichier_3> {

    @Override
    public Fichier_3 Import (String[] ligne, int num_ligne) throws Exception {

        if (ligne.length == 4) {
            // Traitement ...

            LocalDate from_date = parseDate(ligne[0]);
            Integer ref = Integer.parseInt(ligne[1]);
            double base = Double.valueOf(ligne[2]);
            String salary_structure = ligne[3];


            Fichier_3 fichier = new Fichier_3();

            Salary_Structure_assignment_body ssaB = new Salary_Structure_assignment_body(from_date, ""+ref, base, salary_structure);
            fichier.setSalary_Structure_assignment_body(ssaB);
            return fichier;
        } else throw new Exception("Nombre de colonne invalide !!");
    }

    @Override
    public List<String> Export(List<Fichier_3> objets) {
        throw new UnsupportedOperationException("Unimplemented method 'Export'");
    }

    @Override
    public String translate(Map<String, String> data, String input) {
        if (input == null) return "Unknown";
        String cle = input.trim().toLowerCase();
        return data.getOrDefault(cle, input);
    }


    @Override
    public String generateTempName(String doctype) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            randomString.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return "new-" + doctype.toLowerCase() + "-" + randomString.toString();
    }

    @Override
    public String abbreviate(String input) {
        throw new UnsupportedOperationException("Unimplemented method 'abbreviate'");
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

    
}

