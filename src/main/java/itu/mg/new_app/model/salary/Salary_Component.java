package itu.mg.new_app.model.salary;


public class Salary_Component {

    private String name;
    private String owner;
    private String creation;
    private String modified;
    private String modified_by;
    private int docstatus;
    private int idx;
    private String salary_component;
    private String salary_component_abbr;
    private String type;
    private String description;
    private int depends_on_payment_days;
    private int is_tax_applicable;
    private int deduct_full_tax_on_selected_payroll_date;
    private int variable_based_on_taxable_salary;
    private int is_income_tax_component;
    private int exempted_from_income_tax;
    private int round_to_the_nearest_integer;
    private int statistical_component;
    private int do_not_include_in_total;
    private int remove_if_zero_valued;
    private int disabled;
    private String condition;
    private double amount;
    private int amount_based_on_formula;
    private String formula;
    private int is_flexible_benefit;
    private double max_benefit_amount;
    private int pay_against_benefit_claim;
    private int only_tax_impact;
    private int create_separate_payment_entry_against_benefit_claim;

    // Constructeur par défaut
    public Salary_Component() {}

    // Getters et Setters
    public String getName() { return name; }
    public String getOwner() { return owner; }
    public String getCreation() { return creation; }
    public String getModified() { return modified; }
    public String getModified_by() { return modified_by; }
    public int getDocstatus() { return docstatus; }
    public int getIdx() { return idx; }
    public String getSalary_component() { return salary_component; }
    public String getSalary_component_abbr() { return salary_component_abbr; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public int getDepends_on_payment_days() { return depends_on_payment_days; }
    public int getIs_tax_applicable() { return is_tax_applicable; }
    public int getDeduct_full_tax_on_selected_payroll_date() { return deduct_full_tax_on_selected_payroll_date; }
    public int getVariable_based_on_taxable_salary() { return variable_based_on_taxable_salary; }
    public int getIs_income_tax_component() { return is_income_tax_component; }
    public int getExempted_from_income_tax() { return exempted_from_income_tax; }
    public int getRound_to_the_nearest_integer() { return round_to_the_nearest_integer; }
    public int getStatistical_component() { return statistical_component; }
    public int getDo_not_include_in_total() { return do_not_include_in_total; }
    public int getRemove_if_zero_valued() { return remove_if_zero_valued; }
    public int getDisabled() { return disabled; }
    public String getCondition() { return condition; }
    public double getAmount() { return amount; }
    public int getAmount_based_on_formula() { return amount_based_on_formula; }
    public String getFormula() { return formula; }
    public int getIs_flexible_benefit() { return is_flexible_benefit; }
    public double getMax_benefit_amount() { return max_benefit_amount; }
    public int getPay_against_benefit_claim() { return pay_against_benefit_claim; }
    public int getOnly_tax_impact() { return only_tax_impact; }
    public int getCreate_separate_payment_entry_against_benefit_claim() { return create_separate_payment_entry_against_benefit_claim; }


    public void setName(String name) { this.name = name; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setCreation(String creation) { this.creation = creation; }
    public void setModified(String modified) { this.modified = modified; }
    public void setModified_by(String modified_by) { this.modified_by = modified_by; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    public void setIdx(int idx) { this.idx = idx; }
    public void setSalary_component(String salary_component) { this.salary_component = salary_component; }
    public void setSalary_component_abbr(String salary_component_abbr) { this.salary_component_abbr = salary_component_abbr; }
    public void setType(String type) { this.type = type; }
    public void setDescription(String description) { this.description = description; }
    public void setDepends_on_payment_days(int depends_on_payment_days) { this.depends_on_payment_days = depends_on_payment_days; }
    public void setIs_tax_applicable(int is_tax_applicable) { this.is_tax_applicable = is_tax_applicable; }
    public void setDeduct_full_tax_on_selected_payroll_date(int deduct_full_tax_on_selected_payroll_date) { this.deduct_full_tax_on_selected_payroll_date = deduct_full_tax_on_selected_payroll_date; }
    public void setVariable_based_on_taxable_salary(int variable_based_on_taxable_salary) { this.variable_based_on_taxable_salary = variable_based_on_taxable_salary; }
    public void setIs_income_tax_component(int is_income_tax_component) { this.is_income_tax_component = is_income_tax_component; }
    public void setExempted_from_income_tax(int exempted_from_income_tax) { this.exempted_from_income_tax = exempted_from_income_tax; }
    public void setRound_to_the_nearest_integer(int round_to_the_nearest_integer) { this.round_to_the_nearest_integer = round_to_the_nearest_integer; }
    public void setStatistical_component(int statistical_component) { this.statistical_component = statistical_component; }
    public void setDo_not_include_in_total(int do_not_include_in_total) { this.do_not_include_in_total = do_not_include_in_total; }
    public void setRemove_if_zero_valued(int remove_if_zero_valued) { this.remove_if_zero_valued = remove_if_zero_valued; }
    public void setDisabled(int disabled) { this.disabled = disabled; }
    public void setCondition(String condition) { this.condition = condition; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setAmount_based_on_formula(int amount_based_on_formula) { this.amount_based_on_formula = amount_based_on_formula; }
    public void setFormula(String formula) { this.formula = formula; }
    public void setIs_flexible_benefit(int is_flexible_benefit) { this.is_flexible_benefit = is_flexible_benefit; }
    public void setMax_benefit_amount(double max_benefit_amount) { this.max_benefit_amount = max_benefit_amount; }
    public void setPay_against_benefit_claim(int pay_against_benefit_claim) { this.pay_against_benefit_claim = pay_against_benefit_claim; }
    public void setOnly_tax_impact(int only_tax_impact) { this.only_tax_impact = only_tax_impact; }
    public void setCreate_separate_payment_entry_against_benefit_claim(int create_separate_payment_entry_against_benefit_claim) { this.create_separate_payment_entry_against_benefit_claim = create_separate_payment_entry_against_benefit_claim; }
}
