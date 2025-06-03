package itu.mg.new_app.models_form.body;

import java.util.*;

public class Salary_Structure_body {
    
    private String __newname;
    private String company;
    private String is_active = "Yes";
    private String currency = "EUR";
    private String payroll_frequency = "Monthly";
    private int docstatus = 0; // submit false

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
            this.getEarnings().add(new Salary_Detail(salary_component, formula));
        } else if (type.equals("Deduction")) {
            this.getDeductions().add(new Salary_Detail(salary_component, formula));
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

    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    public void setCompany(String company) { this.company = company; }
    public void setEarnings(List<Salary_Detail> earnings) { this.earnings = earnings; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setDeductions(List<Salary_Detail> deductions) { this.deductions = deductions; }
    public void setIs_active(String is_active) { this.is_active = is_active; }
    public void setPayroll_frequency(String payroll_frequency) { this.payroll_frequency = payroll_frequency; }
    public void set__newname(String __newname) { this.__newname = __newname; }
    

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
    private String salary_component;
    private String formula;
    private int amount_based_on_formula = 1;

    public Salary_Detail () {}
    Salary_Detail (String salary_component, String formula) {
        setSalary_component(salary_component);
        setFormula(formula);
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