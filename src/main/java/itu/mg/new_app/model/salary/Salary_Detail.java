package itu.mg.new_app.model.salary;

import java.time.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Salary_Detail {
    
    
    private String name;
    private String owner;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;

    private String modified_by;
    private int docstatus;
    private int idx;
    private String salary_component;
    private String abbr;
    private double amount;
    private double year_to_date;
    private int is_recurring_additional_salary;
    private int statistical_component;
    private int depends_on_payment_days;
    private int exempted_from_income_tax;
    private int is_tax_applicable;
    private int is_flexible_benefit;
    private int variable_based_on_taxable_salary;
    private int do_not_include_in_total;
    private int deduct_full_tax_on_selected_payroll_date;
    private int amount_based_on_formula;
    private double default_amount;
    private double additional_amount;
    private double tax_on_flexible_benefit;
    private double tax_on_additional_salary;
    private String parent;
    private String parentfield;
    private String parenttype;
    private String doctype;


    public Salary_Detail () {}

    public String getName() { return this.name;	}
	public String getOwner() { return this.owner;	}
	public LocalDateTime getCreation() { return this.creation;	}
	public LocalDateTime getModified() { return this.modified;	}
	public String getModified_by() { return this.modified_by;	}
	public int getDocstatus() { return this.docstatus;	}
	public int getIdx() { return this.idx;	}
	public String getSalary_component() { return this.salary_component;	}
	public String getAbbr() { return this.abbr;	}
	public double getAmount() { return this.amount;	}
	public double getYear_to_date() { return this.year_to_date;	}
	public int getIs_recurring_additional_salary() { return this.is_recurring_additional_salary;	}
	public int getStatistical_component() { return this.statistical_component;	}
	public int getDepends_on_payment_days() { return this.depends_on_payment_days;	}
	public int getExempted_from_income_tax() { return this.exempted_from_income_tax;	}
	public int getIs_tax_applicable() { return this.is_tax_applicable;	}
	public int getIs_flexible_benefit() { return this.is_flexible_benefit;	}
	public int getVariable_based_on_taxable_salary() { return this.variable_based_on_taxable_salary;	}
	public int getDo_not_include_in_total() { return this.do_not_include_in_total;	}
	public int getDeduct_full_tax_on_selected_payroll_date() { return this.deduct_full_tax_on_selected_payroll_date;	}
	public int getAmount_based_on_formula() { return this.amount_based_on_formula;	}
	public double getDefault_amount() { return this.default_amount;	}
	public double getAdditional_amount() { return this.additional_amount;	}
	public double getTax_on_flexible_benefit() { return this.tax_on_flexible_benefit;	}
	public double getTax_on_additional_salary() { return this.tax_on_additional_salary;	}
	public String getParent() { return this.parent;	}
	public String getParentfield() { return this.parentfield;	}
	public String getParenttype() { return this.parenttype;	}
	public String getDoctype() { return this.doctype;	}


	public void setName(String name) { this.name = name;	}
	public void setOwner(String owner) { this.owner = owner;	}
	public void setCreation(LocalDateTime creation) { this.creation = creation;	}
	public void setModified(LocalDateTime modified) { this.modified = modified;	}
	public void setModified_by(String modified_by) { this.modified_by = modified_by;	}
	public void setDocstatus(int docstatus) { this.docstatus = docstatus;	}
	public void setIdx(int idx) { this.idx = idx;	}
	public void setSalary_component(String salary_component) { this.salary_component = salary_component;	}
	public void setAbbr(String abbr) { this.abbr = abbr;	}
	public void setAmount(double amount) { this.amount = amount;	}
	public void setYear_to_date(double year_to_date) { this.year_to_date = year_to_date;	}
	public void setIs_recurring_additional_salary(int is_recurring_additional_salary) { this.is_recurring_additional_salary = is_recurring_additional_salary;	}
	public void setStatistical_component(int statistical_component) { this.statistical_component = statistical_component;	}
	public void setDepends_on_payment_days(int depends_on_payment_days) { this.depends_on_payment_days = depends_on_payment_days;	}
	public void setExempted_from_income_tax(int exempted_from_income_tax) { this.exempted_from_income_tax = exempted_from_income_tax;	}
	public void setIs_tax_applicable(int is_tax_applicable) { this.is_tax_applicable = is_tax_applicable;	}
	public void setIs_flexible_benefit(int is_flexible_benefit) { this.is_flexible_benefit = is_flexible_benefit;	}
	public void setVariable_based_on_taxable_salary(int variable_based_on_taxable_salary) { this.variable_based_on_taxable_salary = variable_based_on_taxable_salary;	}
	public void setDo_not_include_in_total(int do_not_include_in_total) { this.do_not_include_in_total = do_not_include_in_total;	}
	public void setDeduct_full_tax_on_selected_payroll_date(int deduct_full_tax_on_selected_payroll_date) { this.deduct_full_tax_on_selected_payroll_date = deduct_full_tax_on_selected_payroll_date;	}
	public void setAmount_based_on_formula(int amount_based_on_formula) { this.amount_based_on_formula = amount_based_on_formula;	}
	public void setDefault_amount(double default_amount) { this.default_amount = default_amount;	}
	public void setAdditional_amount(double additional_amount) { this.additional_amount = additional_amount;	}
	public void setTax_on_flexible_benefit(double tax_on_flexible_benefit) { this.tax_on_flexible_benefit = tax_on_flexible_benefit;	}
	public void setTax_on_additional_salary(double tax_on_additional_salary) { this.tax_on_additional_salary = tax_on_additional_salary;	}
	public void setParent(String parent) { this.parent = parent;	}
	public void setParentfield(String parentfield) { this.parentfield = parentfield;	}
	public void setParenttype(String parenttype) { this.parenttype = parenttype;	}
	public void setDoctype(String doctype) { this.doctype = doctype;	}


 
    
}