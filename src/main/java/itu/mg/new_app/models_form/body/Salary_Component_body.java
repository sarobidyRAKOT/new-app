package itu.mg.new_app.models_form.body;

import java.util.ArrayList;
import java.util.List;

public class Salary_Component_body {
    
    private String salary_component;
    private String salary_component_abbr;
    private String type;
    private int is_tax_applicable; // *** Earning 1 Deduction 0
    
    private String owner = "Administrator";
    private int depends_on_payment_days = 0;
    private int deduct_full_tax_on_selected_payroll_date = 0;
    private int variable_based_on_taxable_salary = 0;
    private int is_income_tax_component = 0;
    private int exempted_from_income_tax = 0;
    private int round_to_the_nearest_integer = 0;
    private int statistical_component = 0;
    private int do_not_include_in_total = 0;
    private int remove_if_zero_valued = 1;
    private int disabled = 0;
    private List <?> accounts = new ArrayList<>();
    private int amount_based_on_formula = 1;
    private int is_flexible_benefit = 0;
    private int pay_against_benefit_claim = 0;
    private int only_tax_impact = 0;
    private int create_separate_payment_entry_against_benefit_claim = 0;


    private String formula;


    @Override
    public String toString() {
        return this.salary_component+" "+salary_component_abbr+" "+type+" "+formula;
    }

    public Salary_Component_body () {}
    public Salary_Component_body (String salary_component, String salary_component_abbr, String type, String formula) {
        this.setSalary_component(salary_component);
        this.setSalary_component_abbr(salary_component_abbr);
        this.setType(type);
        if (type.equals("Deduction")) {
            setIs_tax_applicable(0);
        } else if (type.equals("Earning")) setIs_tax_applicable(1);
        this.setFormula(formula);
    }

    public int getDepends_on_payment_days() { return depends_on_payment_days; }
    public int getAmount_based_on_formula() { return amount_based_on_formula; }
    public String getFormula() { return formula; }
    public String getSalary_component() { return salary_component; }
    public String getSalary_component_abbr() { return salary_component_abbr; }
    public String getType() { return type; }
    public List<?> getAccounts() {
        return accounts;
    }
    public int getCreate_separate_payment_entry_against_benefit_claim() {
        return create_separate_payment_entry_against_benefit_claim;
    }
    public int getDeduct_full_tax_on_selected_payroll_date() {
        return deduct_full_tax_on_selected_payroll_date;
    }
    public int getDisabled() {
        return disabled;
    }
    public int getDo_not_include_in_total() {
        return do_not_include_in_total;
    }
    public int getExempted_from_income_tax() {
        return exempted_from_income_tax;
    }
    public int getIs_flexible_benefit() {
        return is_flexible_benefit;
    }
    public int getIs_income_tax_component() {
        return is_income_tax_component;
    }
    public int getIs_tax_applicable() {
        return is_tax_applicable;
    }
    public int getOnly_tax_impact() {
        return only_tax_impact;
    }
    public String getOwner() {
        return owner;
    }
    public int getPay_against_benefit_claim() {
        return pay_against_benefit_claim;
    }
    public int getRemove_if_zero_valued() {
        return remove_if_zero_valued;
    }
    public int getRound_to_the_nearest_integer() {
        return round_to_the_nearest_integer;
    }
    public int getStatistical_component() {
        return statistical_component;
    }
    public int getVariable_based_on_taxable_salary() {
        return variable_based_on_taxable_salary;
    }


    public void setAccounts(List<?> accounts) {
        this.accounts = accounts;
    }
    public void setCreate_separate_payment_entry_against_benefit_claim(
            int create_separate_payment_entry_against_benefit_claim) {
        this.create_separate_payment_entry_against_benefit_claim = create_separate_payment_entry_against_benefit_claim;
    }
    public void setDeduct_full_tax_on_selected_payroll_date(int deduct_full_tax_on_selected_payroll_date) {
        this.deduct_full_tax_on_selected_payroll_date = deduct_full_tax_on_selected_payroll_date;
    }
    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }
    public void setDo_not_include_in_total(int do_not_include_in_total) {
        this.do_not_include_in_total = do_not_include_in_total;
    }
    public void setExempted_from_income_tax(int exempted_from_income_tax) {
        this.exempted_from_income_tax = exempted_from_income_tax;
    }
    public void setIs_flexible_benefit(int is_flexible_benefit) {
        this.is_flexible_benefit = is_flexible_benefit;
    }
    public void setIs_income_tax_component(int is_income_tax_component) {
        this.is_income_tax_component = is_income_tax_component;
    }
    public void setIs_tax_applicable(int is_tax_applicable) {
        this.is_tax_applicable = is_tax_applicable;
    }
    public void setOnly_tax_impact(int only_tax_impact) {
        this.only_tax_impact = only_tax_impact;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setPay_against_benefit_claim(int pay_against_benefit_claim) {
        this.pay_against_benefit_claim = pay_against_benefit_claim;
    }
    public void setRemove_if_zero_valued(int remove_if_zero_valued) {
        this.remove_if_zero_valued = remove_if_zero_valued;
    }public void setRound_to_the_nearest_integer(int round_to_the_nearest_integer) {
        this.round_to_the_nearest_integer = round_to_the_nearest_integer;
    }
    public void setStatistical_component(int statistical_component) {
        this.statistical_component = statistical_component;
    }
    public void setVariable_based_on_taxable_salary(int variable_based_on_taxable_salary) {
        this.variable_based_on_taxable_salary = variable_based_on_taxable_salary;
    }
    
    public void setDepends_on_payment_days(int depends_on_payment_days) { this.depends_on_payment_days = depends_on_payment_days; }
    public void setAmount_based_on_formula(int amount_based_on_formula) { this.amount_based_on_formula = amount_based_on_formula; }
    public void setFormula(String formula) { this.formula = formula; }
    public void setSalary_component(String salary_component) { this.salary_component = salary_component; }
    public void setSalary_component_abbr(String salary_component_abbr) { this.salary_component_abbr = salary_component_abbr; }
    public void setType(String type) { this.type = type; }
}
