package itu.mg.new_app.utilitaires.result_import;

import java.util.*;

import itu.mg.new_app.model.body.*;

public class Fichier_3 {


    private Set <Salary_Slip_body> salary_Slips;
    private Set <Salary_Structure_Assignment_body> salary_Structure_Assignments;
    private List <String> errors;

    public Fichier_3 () {
        this.salary_Structure_Assignments = new HashSet<>();
        this.salary_Slips = new HashSet <> ();
        this.errors = new ArrayList<>();
    }
    
    public void addSalary_StructureAssignment (Salary_Structure_Assignment_body ssaB) { this.salary_Structure_Assignments.add(ssaB);}
    public void addSalary_Slip (Salary_Slip_body ssB) { this.salary_Slips.add(ssB);}
    public void addErrors (String error) { this.errors.add(error);}
    
    public List<String> getErrors() { return errors;}
    public Set <Salary_Slip_body> getSalary_Slips() { return salary_Slips; }
    public Set <Salary_Structure_Assignment_body> getSalary_Structure_Assignments() { return salary_Structure_Assignments; }

}
