package itu.mg.new_app.model.body;

import java.time.LocalDate;

public class Salary_Slip_body {

    private String employee;
    private LocalDate posting_date;
    private String company;
    private String salary_structure;
    private LocalDate start_date;
    private LocalDate end_date;
    private String payroll_frequency;
    private int docstatus = 1; // status submit ***

    public Salary_Slip_body (LocalDate start_date, String employee) {
        posting_date = LocalDate.now();

    }


    public int getDocstatus() { return docstatus; }
    public void setCompany(String company) { this.company = company; }
    public void setEmployee(String employee) { this.employee = employee; }
    public void setEnd_date(LocalDate end_date) { this.end_date = end_date; }
    public void setPayroll_frequency(String payroll_frequency) { this.payroll_frequency = payroll_frequency; }
    public void setPosting_date(LocalDate posting_date) { this.posting_date = posting_date; }
    public void setSalary_structure(String salary_structure) { this.salary_structure = salary_structure; }
    public void setStart_date(LocalDate start_date) { this.start_date = start_date; }
    
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    public String getCompany() { return company; }
    public String getEmployee() { return employee; }
    public String getEnd_date() { return end_date.toString(); }
    public String getPayroll_frequency() { return payroll_frequency; }
    public String getPosting_date() { return posting_date.toString(); }
    public String getSalary_structure() { return salary_structure; }
    public String getStart_date() { return start_date.toString(); }
    
}
