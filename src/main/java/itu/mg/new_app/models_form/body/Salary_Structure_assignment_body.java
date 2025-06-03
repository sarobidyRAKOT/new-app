package itu.mg.new_app.models_form.body;

import java.time.LocalDate;

public class Salary_Structure_assignment_body {
    private String employee;
    private String salary_structure;
    private String company;
    private LocalDate from_date;
    private double base;
    private int docstatus = 0; // false submit


    public Salary_Structure_assignment_body (LocalDate from_date, String employee, double base, String salary_structure) {
        setFrom_date(from_date);
        setEmployee(employee);
        setSalary_structure(salary_structure);
        setBase(base);
    }

    public String getEmployee() {return this.employee; }
    public int getDocstatus() {return docstatus; }
    public void setDocstatus(int docstatus) {this.docstatus = docstatus; }
    public void setEmployee(String employee) {this.employee = employee; }
    public String getSalary_structure() {return this.salary_structure; }
    public void setSalary_structure(String salary_structure) {this.salary_structure = salary_structure; }
    public String getCompany() {return this.company; }
    public void setCompany(String company) {this.company = company; }
    public LocalDate getFrom_date() {return this.from_date; }
    public void setFrom_date(LocalDate from_date) {this.from_date = from_date; }
    public double getBase() {return this.base; }
    public void setBase(double base) {this.base = base; }


    
}
