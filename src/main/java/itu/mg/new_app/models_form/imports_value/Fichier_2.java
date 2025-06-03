package itu.mg.new_app.models_form.imports_value;

import itu.mg.new_app.models_form.body.*;

public class Fichier_2 {
    
    private Salary_Component_body salary_Component_body;
    private Salary_Structure_body salary_Structure_body;

    public Fichier_2 (Salary_Component_body salary_Component_body, Salary_Structure_body salary_Structure_body) {
        this.setSalary_Component_body(salary_Component_body);
        this.setSalary_Structure_body(salary_Structure_body);
    }

    public Salary_Component_body getSalary_Component_body() { return salary_Component_body; }
    public Salary_Structure_body getSalary_Structure_body() { return salary_Structure_body; }
    public void setSalary_Component_body(Salary_Component_body salary_Component_body) { this.salary_Component_body = salary_Component_body; }
    public void setSalary_Structure_body(Salary_Structure_body salary_Structure_body) { this.salary_Structure_body = salary_Structure_body; }
    
}
