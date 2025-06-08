package itu.mg.new_app.models_form.body;

import java.util.*;

public class Salary_Structure_body {
    
    private int docstatus = 0; // submit false
    private String owner = "Administrator";
    private String company;
    private String is_active = "Yes";
    private String is_default = "No";
    private String currency = "EUR";
    private int salary_slip_based_on_timesheet = 0;
    private String payroll_frequency = "Monthly";
    private String __newname;
    private List <Salary_Detail> earnings = new ArrayList<>();
    private List <Salary_Detail> deductions = new ArrayList<>();




    public Salary_Structure_body () {}
    public Salary_Structure_body (String __newname, String company, String type, String salary_component, String formula) {
        this.set__newname(__newname);
        this.setCompany(company);
        this.add_Salary_Detail(type, salary_component, formula);
    }


    @Override
    public String toString() {
        String es = "";
        String ds = "";
        for (Salary_Detail sd : earnings)  es+= sd.getSalary_component()+", ";
        for (Salary_Detail sd : deductions) ds += sd.getSalary_component()+", ";
        return __newname+" "+company+"\n Earnings : {"+es+"}\n Deductions : {"+ds+"}";
    }


    public void add_Salary_Detail (String type, String salary_component, String formula) {
        if (type.equals("Earning")) {      
            Salary_Detail salary_detail = new Salary_Detail(salary_component, formula);
            salary_detail.setIs_tax_applicable(1);
            salary_detail.setParentfield("earnings");
            this.getEarnings().add(salary_detail);
        } else if (type.equals("Deduction")) {
            Salary_Detail salary_detail = new Salary_Detail(salary_component, formula);
            salary_detail.setIs_tax_applicable(0);
            salary_detail.setParentfield("deductions");
            this.getDeductions().add(salary_detail);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Salary_Structure_body ssBody = (Salary_Structure_body) obj;
        return Objects.equals(__newname, ssBody.__newname) && 
            Objects.equals(company, ssBody.company) &&
            Objects.equals(is_active, ssBody.is_active) &&
            Objects.equals(currency, ssBody.currency) && 
            Objects.equals(payroll_frequency, ssBody.payroll_frequency);
    }
    @Override
    public int hashCode() {
        return Objects.hash(__newname, company, is_active, currency, payroll_frequency);
    }

    public String getIs_default() {
        return is_default;
    }
    public String getOwner() {
        return owner;
    }
    public int getSalary_slip_based_on_timesheet() {
        return salary_slip_based_on_timesheet;
    }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    public void setCompany(String company) { this.company = company; }
    public void setEarnings(List<Salary_Detail> earnings) { this.earnings = earnings; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setDeductions(List<Salary_Detail> deductions) { this.deductions = deductions; }
    public void setIs_active(String is_active) { this.is_active = is_active; }
    public void setPayroll_frequency(String payroll_frequency) { this.payroll_frequency = payroll_frequency; }
    public void set__newname(String __newname) { this.__newname = __newname; }
    

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setSalary_slip_based_on_timesheet(int salary_slip_based_on_timesheet) {
        this.salary_slip_based_on_timesheet = salary_slip_based_on_timesheet;
    }
    public int getDocstatus() { return docstatus; }
    public String getCompany() { return company; }
    public String getCurrency() { return currency; }
    public List<Salary_Detail> getDeductions() { return deductions; }
    public List<Salary_Detail> getEarnings() { return earnings; }
    public String getIs_active() { return is_active; }
    public String getPayroll_frequency() { return payroll_frequency; }
    public String get__newname() { return __newname; }


}

class Salary_Detail {
    private int docstatus = 0;
    private String owner = "Administrator";

    private int is_recurring_additional_salary = 0;
    private int statistical_component = 0;
    private int depends_on_payment_days = 0;
    private int exempted_from_income_tax = 0;
    private int is_tax_applicable; // Earning 1 Deduction 0
    private int is_flexible_benefit = 0;
    private int variable_based_on_taxable_salary = 0;
    private int do_not_include_in_total = 0;
    private int deduct_full_tax_on_selected_payroll_date = 0;
    private int amount_based_on_formula = 1;
    private String parentfield; // earnings deductions
    private String parenttype = "Salary Structure";
    private String salary_component;
    private String formula;
    

    public Salary_Detail () {}
    Salary_Detail (String salary_component, String formula) {
        setSalary_component(salary_component);
        setFormula(formula);
    }

    public int getDeduct_full_tax_on_selected_payroll_date() {
        return deduct_full_tax_on_selected_payroll_date;
    }
    public int getDo_not_include_in_total() {
        return do_not_include_in_total;
    }
    public int getDocstatus() {
        return docstatus;
    }
    public int getExempted_from_income_tax() {
        return exempted_from_income_tax;
    }
    public int getIs_flexible_benefit() {
        return is_flexible_benefit;
    }
    public int getIs_recurring_additional_salary() {
        return is_recurring_additional_salary;
    }
    public int getIs_tax_applicable() {
        return is_tax_applicable;
    }
    public String getOwner() {
        return owner;
    }
    public String getParentfield() {
        return parentfield;
    }
    public String getParenttype() {
        return parenttype;
    }

    public int getStatistical_component() {
        return statistical_component;
    }
    public int getVariable_based_on_taxable_salary() {
        return variable_based_on_taxable_salary;
    }
    
    public void setDeduct_full_tax_on_selected_payroll_date(int deduct_full_tax_on_selected_payroll_date) {
        this.deduct_full_tax_on_selected_payroll_date = deduct_full_tax_on_selected_payroll_date;
    }
    public void setDo_not_include_in_total(int do_not_include_in_total) {
        this.do_not_include_in_total = do_not_include_in_total;
    }
    public void setDocstatus(int docstatus) {
        this.docstatus = docstatus;
    }
    public void setExempted_from_income_tax(int exempted_from_income_tax) {
        this.exempted_from_income_tax = exempted_from_income_tax;
    }
    public void setIs_flexible_benefit(int is_flexible_benefit) {
        this.is_flexible_benefit = is_flexible_benefit;
    }
    public void setIs_recurring_additional_salary(int is_recurring_additional_salary) {
        this.is_recurring_additional_salary = is_recurring_additional_salary;
    }
    public void setIs_tax_applicable(int is_tax_applicable) {
        this.is_tax_applicable = is_tax_applicable;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setParentfield(String parentfield) {
        this.parentfield = parentfield;
    }
    public void setParenttype(String parenttype) {
        this.parenttype = parenttype;
    }
    public void setStatistical_component(int statistical_component) {
        this.statistical_component = statistical_component;
    }
    public void setVariable_based_on_taxable_salary(int variable_based_on_taxable_salary) {
        this.variable_based_on_taxable_salary = variable_based_on_taxable_salary;
    }
    public int getDepends_on_payment_days() {
        return depends_on_payment_days;
    }
    public void setDepends_on_payment_days(int depends_on_payment_days) {
        this.depends_on_payment_days = depends_on_payment_days;
    }
    public int getAmount_based_on_formula() {
        return amount_based_on_formula;
    }
    public void setAmount_based_on_formula(int amount_based_on_formula) {
        this.amount_based_on_formula = amount_based_on_formula;
    }
    public String getFormula() {
        return formula;
    }
    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setSalary_component(String salary_component) { this.salary_component = salary_component; }
    public String getSalary_component() { return salary_component; }
}