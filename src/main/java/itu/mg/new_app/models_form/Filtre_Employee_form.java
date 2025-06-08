package itu.mg.new_app.models_form;

import java.time.LocalDate;

public class Filtre_Employee_form {
    
    private String gender;
    private String department;
    private String company;
    private LocalDate date_of_birthMin;
    private LocalDate date_of_birthMax;
    private String designation;
    private String status = "Active";

    public Filtre_Employee_form () {}

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCompany() { return company; }
    public LocalDate getDate_of_birthMax() { return date_of_birthMax; }
    public LocalDate getDate_of_birthMin() { return date_of_birthMin; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public String getStatus() { return status; }

    public void setCompany(String company) { this.company = company; }
    public void setDate_of_birthMax(LocalDate date_of_birthMax) { this.date_of_birthMax = date_of_birthMax; }
    public void setDate_of_birthMin(LocalDate date_of_birthMin) { this.date_of_birthMin = date_of_birthMin; }
    public void setDepartment(String department) { this.department = department; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setStatus(String status) { this.status = status; }
}
