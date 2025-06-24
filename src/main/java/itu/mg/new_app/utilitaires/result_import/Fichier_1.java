package itu.mg.new_app.utilitaires.result_import;



import java.util.*;

import itu.mg.new_app.model.body.*;

public class Fichier_1 {
    
    private List <String> errors;
    private Set <Employee_body> employee_bodies;
    private Set <Company_body> company_bodies;
    private Holiday_List_body holiday_List_body;



    public Fichier_1 () {
        holiday_List_body = new Holiday_List_body(); // *** HOLIDAY_LIST par defaut ***
        this.errors = new ArrayList<> ();
        this.company_bodies = new HashSet <Company_body>();
        this.employee_bodies = new HashSet <Employee_body>();
    }

    public Holiday_List_body getHoliday_List_body() { return holiday_List_body; }
    // public void setHoliday_List_body(Holiday_List_body holiday_List_body) { this.holiday_List_body = holiday_List_body; }
    public Set<Company_body> getCompany_bodies() { return company_bodies; }
    public Set<Employee_body> getEmployee_bodies() { return employee_bodies; }
    public List<String> getErrors() { return errors; }
    
    public void addCompany_bodies(Company_body company_body) { this.company_bodies.add(company_body); }
    public void addEmployee_bodies(Employee_body employee_body) { this.employee_bodies.add(employee_body); }
    public void addErrors(String error) { this.errors.add(error); }
    
}
