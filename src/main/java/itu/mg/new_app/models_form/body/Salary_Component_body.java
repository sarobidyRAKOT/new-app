package itu.mg.new_app.models_form.body;

public class Salary_Component_body {
    
    private String salary_component;
    private String salary_component_abbr;
    private String type;
    private int amount_based_on_formula = 1;
    private int depends_on_payment_days = 0;    
    private String formula;


    @Override
    public String toString() {
        return this.salary_component+" "+salary_component_abbr+" "+type+" "+formula;
    }

    public Salary_Component_body () {}
    public Salary_Component_body (String salary_component, String salary_component_abbr, String type, String formula) {
        this.setSalary_component(salary_component_abbr);
        this.setSalary_component_abbr(salary_component_abbr);
        this.setType(type);
        this.setFormula(formula);
    }

    public int getDepends_on_payment_days() { return depends_on_payment_days; }
    public int getAmount_based_on_formula() { return amount_based_on_formula; }
    public String getFormula() { return formula; }
    public String getSalary_component() { return salary_component; }
    public String getSalary_component_abbr() { return salary_component_abbr; }
    public String getType() { return type; }
    

    public void setDepends_on_payment_days(int depends_on_payment_days) { this.depends_on_payment_days = depends_on_payment_days; }
    public void setAmount_based_on_formula(int amount_based_on_formula) { this.amount_based_on_formula = amount_based_on_formula; }
    public void setFormula(String formula) { this.formula = formula; }
    public void setSalary_component(String salary_component) { this.salary_component = salary_component; }
    public void setSalary_component_abbr(String salary_component_abbr) { this.salary_component_abbr = salary_component_abbr; }
    public void setType(String type) { this.type = type; }
}
