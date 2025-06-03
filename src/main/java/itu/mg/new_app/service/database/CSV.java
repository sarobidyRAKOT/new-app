package itu.mg.new_app.service.database;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import itu.mg.new_app.model.Company;
import itu.mg.new_app.utilitaires.ImportExport_impl;
import itu.mg.new_app.utilitaires.traitement.Import_fichier1;


@Service
public class CSV {
    

    public <T> HashMap <String, List <?>> import_CSV (MultipartFile file, ImportExport_impl<T> importExport_CSV) {
        
        
        HashMap <String, List <?>> valiny = new HashMap <String, List <?>> ();
        List <T> items = new ArrayList <> ();
        List <String> errors = new ArrayList<>();
        CSVReader csvReader = null;
        
        try {
            File CSVtempFile = File.createTempFile("upload_", "_" + file.getOriginalFilename());
            file.transferTo(CSVtempFile);
            
            String pathFile = CSVtempFile.getAbsolutePath();
            csvReader = new CSVReader(new FileReader(pathFile));
            int num_ligne = 1;
            String[] ligne;
            csvReader.readNext(); // lire le titre *** 
            while ((ligne = csvReader.readNext()) != null) {
                try {
                    T item = importExport_CSV.Import (ligne, num_ligne);
                    items.add(item);
                } catch (Exception e) {
                    errors.add("Error a la ligne "+num_ligne+", exception :"+e.getMessage()+", cause: "+e.getCause());
                }
                ++ num_ligne;
            }

            csvReader.close();
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        valiny.put("items", items);
        valiny.put("errors", errors);
        
        return valiny;
    }


    public <T> File export_CSV (String pathFile, ImportExport_impl<T> importExport_CSV, List <T> objets) {

        File fichier = new File(pathFile);
        FileWriter writer = null;

        try {
            if (!fichier.exists()) {
                fichier.createNewFile();
            }

            writer = new FileWriter(fichier);
            List <String> lignes = importExport_CSV.Export (objets);

            if (lignes == null || lignes.isEmpty()) {
                writer.close();
                return fichier;
            }

            int index = 0;
            while (index < lignes.size()) {
                writer.append(lignes.get(index)+"\n");
                ++ index;
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fichier;
    }



    public boolean isValid(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            throw new Exception("Aucun fichier sélectionné.");
        }

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !originalFilename.toLowerCase().endsWith(".csv")) {
            throw new Exception("Le fichier doit être au format .csv.");
        }

        return true;
    }


    // public HashMap <String, Set <?>> readFichier1 (MultipartFile fichier, List <Company> companies) throws IOException {

    //     File CSVtempFile = File.createTempFile("upload_", "_" + fichier.getOriginalFilename());
    //     fichier.transferTo(CSVtempFile);

    //     Import_fichier1 import_fichier1 = new Import_fichier1();
    //     import_fichier1.setCompanies(companies);

    //     HashMap <String, List<?>> hashMap = ;


    //     return null;
    // }


}
