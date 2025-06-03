package itu.mg.new_app.models_form.body;

import java.time.LocalDate;
import java.util.Objects;


public class Employee_body {
    
    private String gender;
    private LocalDate date_of_joining;
    private LocalDate date_of_birth;
    private String status = "Active";
    private String company;
    private String middle_name;
    private String first_name;


    public Employee_body (String first_name, String middle_name, String gender, LocalDate date_of_joining, LocalDate date_of_birth, String company) {
        setGender(gender);
        setDate_of_joining(date_of_joining);
        setDate_of_birth(date_of_birth); 
        setCompany(company);
        setMiddle_name(middle_name);
        setFirst_name(first_name); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee_body c = (Employee_body) obj;

        return Objects.equals(this.gender, c.gender) &&
        Objects.equals(this.date_of_joining, c.date_of_joining) &&
        Objects.equals(this.date_of_birth, c.date_of_birth) &&
        Objects.equals(this.status, c.status) &&
        Objects.equals(this.company, c.company) &&
        Objects.equals(this.middle_name, c.middle_name) &&
        Objects.equals(this.first_name, c.first_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, date_of_joining, date_of_birth, status, company, middle_name , first_name);
    }

    public String getCompany() { return company; }
    public LocalDate getDate_of_birth() { return date_of_birth; }
    public LocalDate getDate_of_joining() { return date_of_joining; }
    public String getGender() { return gender; }
    public String getStatus() { return status; }
    public String getFirst_name() { return first_name; }
    public String getMiddle_name() { return middle_name; }


    public void setFirst_name(String first_name) { this.first_name = first_name; }
    public void setMiddle_name(String middle_name) { this.middle_name = middle_name; }
    public void setCompany(String company) { this.company = company; }
    public void setDate_of_birth(LocalDate date_of_birth) { this.date_of_birth = date_of_birth; }
    public void setDate_of_joining(LocalDate date_of_joining) { this.date_of_joining = date_of_joining; }
    public void setGender(String gender) { this.gender = gender; }
    public void setStatus(String status) { this.status = status; }


}
