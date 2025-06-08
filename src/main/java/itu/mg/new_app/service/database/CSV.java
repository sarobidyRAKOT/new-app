package itu.mg.new_app.service.database;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import itu.mg.new_app.model.employee.Employee;
import itu.mg.new_app.model.salary.Salary_Structure;
import itu.mg.new_app.models_form.body.*;
import itu.mg.new_app.utilitaires.*;


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

    @SuppressWarnings("null")
    public boolean valider_SalaryStructureAssignment (Set <Salary_Structure_assignment_body> salary_Structure_assignment_bodies,
        List <Employee> employees, List <Salary_Structure> salary_Structures) throws Exception {
        
        int i = 0;
        for (Salary_Structure_assignment_body ssaB : salary_Structure_assignment_bodies) {
            // validation SALARY STRUCTURE ASSIGNMENT ****
            Employee e = employees.get(Integer.parseInt(ssaB.getEmployee())-1); // get employee
            Salary_Structure ss = null;
            for (Salary_Structure salary_Structure : salary_Structures) {
                //  GET SALARY STRUCTURE ***
                if (salary_Structure.getName().equals(ssaB.getSalary_structure())) {
                    ss = salary_Structure;
                }
            }

            if (ss != null & e.getCompany().equals(ss.getCompany())) {
                ssaB.setEmployee(e.getEmployee());
                ssaB.setCompany(e.getCompany());
            } else {
                throw new Exception("Invalide Salary structure asignment ligne "+i+1);
            }
            ++ i;
        }
        return true;
    }

    public boolean validerFichier (MultipartFile fichier, String attributErreur, Model model) {
        try {
            this.isValid(fichier);
            return true;
        } catch (Exception e) {
            model.addAttribute(attributErreur, e.getMessage());
            return false;
        }
    }


}
