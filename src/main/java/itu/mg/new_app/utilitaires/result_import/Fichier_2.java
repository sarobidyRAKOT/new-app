package itu.mg.new_app.utilitaires.result_import;

import java.util.*;

import itu.mg.new_app.model.body.*;

public class Fichier_2 {
    
    private List <String> errors;
    private Set <Salary_Component_body> salary_Component_bodies;
    private Set <Salary_Structure_body> salary_Structure_bodies;

    public Fichier_2 () {
        this.errors = new ArrayList<>();
        this.salary_Component_bodies = new HashSet<>();
        this.salary_Structure_bodies = new HashSet<>();
    }

    public List<String> getErrors() { return errors; }
    public Set<Salary_Component_body> getSalary_Component_bodies() { return salary_Component_bodies; }
    public Set<Salary_Structure_body> getSalary_Structure_bodies() { return salary_Structure_bodies; }
    public void addErrors(String error) { this.errors.add(error); }
    public void addSalary_Component_bodies(Salary_Component_body salary_Component_body) { this.salary_Component_bodies.add(salary_Component_body); }
    public void addSalary_Structure_bodies(Salary_Structure_body salary_Structure_body) { this.salary_Structure_bodies.add(salary_Structure_body); }

    
}
