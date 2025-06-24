package itu.mg.new_app.utilitaires.traitement_import;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


import itu.mg.new_app.model.*;
import itu.mg.new_app.model.body.*;
import itu.mg.new_app.utilitaires.result_import.Fichier_1;

public class Import_fichier1 implements ImportExport_impl <Fichier_1> {

    private static final Map<String, String> genderMap = new HashMap<>();
    private List <String> companies_name = new ArrayList<>();
    private final Fichier_1 fichier_1 = new Fichier_1 ();
    static {

        genderMap.put("masculin", "Male");
        genderMap.put("féminin", "Female");
        genderMap.put("feminin", "Female");

        // GENDER DATA MAP PAR DEFAUT ***
        genderMap.put("male", "Male");
        genderMap.put("female", "Female");
        genderMap.put("other", "Other");
        genderMap.put("transgender", "Transgender");
        genderMap.put("genderqueer", "Genderqueer");
        genderMap.put("non-conforming", "Non-Conforming");
        genderMap.put("prefer not to say", "Prefer not to say");
    }


    public Import_fichier1 (List <Company> companies) {
        for (Company company : companies) this.companies_name.add(company.getName());
    }
    
    

    @Override
    public List<String> Export(List<Fichier_1> objets) {
        throw new UnsupportedOperationException("Unimplemented method 'Export'");
    }


    public String translate(Map<String, String> data, String input) {
        if (input == null) return "Unknown";
        String cle = input.trim().toLowerCase();
        return data.getOrDefault(cle, input);
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
    public String abbreviate (String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder abbreviation = new StringBuilder();
        String[] words = input.split("[\\s\\-()]+"); // split par espace, tiret, parenthèses

        for (String word : words) {
            if (!word.isEmpty()) {
                abbreviation.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        return abbreviation.toString();
    }





    @Override
    public void Import (String[] ligne, int num_ligne) {
        if (ligne.length == 7) { // colonne par ligne ***

            // int ref = Integer.parseInt(ligne[0]);
            String first_name = ligne[1];
            String middle_name = ligne[2];
            String gender = translate(genderMap, ligne[3]); // transalte ***
            LocalDate date_ofJoining = parseDate(ligne[4]);
            LocalDate date_ofBirth = parseDate(ligne[5]);
            String company = ligne[6];
            String holiday_List = fichier_1.getHoliday_List_body().getHoliday_list_name();
            if (!this.companies_name.contains(company)) {
                fichier_1.addCompany_bodies (new Company_body(company, abbreviate(company), holiday_List));
                this.companies_name.add(company);
            }
            fichier_1.addEmployee_bodies (new Employee_body(first_name, middle_name, gender, date_ofJoining, date_ofBirth, company));
            
            // return fichier;
        } else fichier_1.addErrors ("Nombre de colonne invalide a la ligne "+num_ligne);
    }



    @Override
    public Fichier_1 get_result() {
        return this.fichier_1;
    }



    
}

