package itu.mg.new_app.model.salary;

import java.time.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Salary_Structure_Assignment { // Assignée structure a un employée ***
    

    private String name;
    private String owner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;
    private String modified_by;
    private int docstatus;
    private int idx;
    private String employee;
    private String employee_name;
    private String department;
    private String designation;
    private String grade;
    private String salary_structure;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate from_date;
    private String income_tax_slab;
    private String company;
    private String payroll_payable_account;
    private String currency;
    private double base;
    private double variable;
    private String amended_from;
    private double taxable_earnings_till_date;
    private double tax_deducted_till_date;


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public LocalDateTime getCreation() { return creation; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }
    public LocalDateTime getModified() { return modified; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }
    public String getModified_by() { return modified_by; }
    public void setModified_by(String modified_by) { this.modified_by = modified_by; }
    public int getDocstatus() { return docstatus; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }
    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }
    public String getEmployee_name() { return employee_name; }
    public void setEmployee_name(String employee_name) { this.employee_name = employee_name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getSalary_structure() { return salary_structure; }
    public void setSalary_structure(String salary_structure) { this.salary_structure = salary_structure; }
    public LocalDate getFrom_date() { return from_date; }
    public void setFrom_date(LocalDate from_date) { this.from_date = from_date; }
    public String getIncome_tax_slab() { return income_tax_slab; }
    public void setIncome_tax_slab(String income_tax_slab) { this.income_tax_slab = income_tax_slab; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getPayroll_payable_account() { return payroll_payable_account; }
    public void setPayroll_payable_account(String payroll_payable_account) { this.payroll_payable_account = payroll_payable_account; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public double getBase() { return base; }
    public void setBase(double base) { this.base = base; }
    public double getVariable() { return variable; }
    public void setVariable(double variable) { this.variable = variable; }
    public String getAmended_from() { return amended_from; }
    public void setAmended_from(String amended_from) { this.amended_from = amended_from; }
    public double getTaxable_earnings_till_date() { return taxable_earnings_till_date; }
    public void setTaxable_earnings_till_date(double taxable_earnings_till_date) { this.taxable_earnings_till_date = taxable_earnings_till_date; }
    public double getTax_deducted_till_date() { return tax_deducted_till_date; }
    public void setTax_deducted_till_date(double tax_deducted_till_date) { this.tax_deducted_till_date = tax_deducted_till_date; }

}
