package itu.mg.new_app.model.salary;

import java.time.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Salary_Slip {
    
    private String name;
    private String owner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;
    private String modified_by;
    private Integer docstatus;
    private Integer idx;
    private String employee;
    private String employee_name;
    private String company;
    private String department;
    private String designation;
    private String branch;
    private LocalDate posting_date;
    private String letter_head;
    private String status;
    private String salary_withholding;
    private String salary_withholding_cycle;
    private String currency;
    private Double exchange_rate;
    private String payroll_frequency;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate end_date;
    private String salary_structure;
    private String payroll_entry;
    private String mode_of_payment;
    private Boolean salary_slip_based_on_timesheet;
    private Boolean deduct_tax_for_unclaimed_employee_benefits;
    private Boolean deduct_tax_for_unsubmitted_tax_exemption_proof;
    private Double total_working_days;
    private Double unmarked_days;
    private Double leave_without_pay;
    private Double absent_days;
    private Double payment_days;
    private Double total_working_hours;
    private Double hour_rate;
    private Double base_hour_rate;
    private double gross_pay;
    private Double base_gross_pay;
    private Double gross_year_to_date;
    private Double base_gross_year_to_date;
    private double total_deduction;
    private Double base_total_deduction;
    private double net_pay;
    private Double base_net_pay;
    private Double rounded_total;
    private Double base_rounded_total;
    private Double year_to_date;
    private Double base_year_to_date;
    private Double month_to_date;
    private Double base_month_to_date;
    private String total_in_words;
    private String base_total_in_words;
    private Double ctc;
    private Double income_from_other_sources;
    private double total_earnings;
    private Double non_taxable_earnings;
    private Double standard_tax_exemption_amount;
    private Double tax_exemption_declaration;
    private Double deductions_before_tax_calculation;
    private Double annual_taxable_amount;
    private Double income_tax_deducted_till_date;
    private Double current_month_income_tax;
    private Double future_income_tax_deductions;
    private Double total_income_tax;//
    private String journal_entry;
    private String amended_from;
    private String bank_name;
    private String bank_account_no;
    private List <Salary_Detail> earnings;
    private List <Salary_Detail> deductions;


    public Salary_Slip () {}

    public void somme (Salary_Slip salary_Slip) {
        
        this.gross_pay += salary_Slip.getGross_pay();
        this.total_earnings += salary_Slip.getTotal_earnings();
        this.total_deduction += salary_Slip.getTotal_deduction();
        this.net_pay += salary_Slip.getNet_pay();
    }

    public List<Salary_Detail> getDeductions() { return deductions; }
    public List<Salary_Detail> getEarnings() { return earnings; }
    public String getName() { return this.name; }
    public String getOwner() { return this.owner; }
    public LocalDateTime getCreation() { return this.creation; }
    public LocalDateTime getModified() { return this.modified; }
    public String getModified_by() { return this.modified_by; }
    public Integer getDocstatus() { return this.docstatus; }
    public Integer getIdx() { return this.idx; }
    public String getEmployee() { return this.employee; }
    public String getEmployee_name() { return this.employee_name; }
    public String getCompany() { return this.company; }
    public String getDepartment() { return this.department; }
    public String getDesignation() { return this.designation; }
    public String getBranch() { return this.branch; }
    public LocalDate getPosting_date() { return this.posting_date; }
    public String getLetter_head() { return this.letter_head; }
    public String getStatus() { return this.status; }
    public String getSalary_withholding() { return this.salary_withholding; }
    public String getSalary_withholding_cycle() { return this.salary_withholding_cycle; }
    public String getCurrency() { return this.currency; }
    public Double getExchange_rate() { return this.exchange_rate; }
    public String getPayroll_frequency() { return this.payroll_frequency; }
    public LocalDate getStart_date() { return this.start_date; }
    public LocalDate getEnd_date() { return this.end_date; }
    public String getSalary_structure() { return this.salary_structure; }
    public String getPayroll_entry() { return this.payroll_entry; }
    public String getMode_of_payment() { return this.mode_of_payment; }
    public Boolean getSalary_slip_based_on_timesheet() { return this.salary_slip_based_on_timesheet; }
    public Boolean getDeduct_tax_for_unclaimed_employee_benefits() { return this.deduct_tax_for_unclaimed_employee_benefits; }
    public Boolean getDeduct_tax_for_unsubmitted_tax_exemption_proof() { return this.deduct_tax_for_unsubmitted_tax_exemption_proof; }
    public Double getTotal_working_days() { return this.total_working_days; }
    public Double getUnmarked_days() { return this.unmarked_days; }
    public Double getLeave_without_pay() { return this.leave_without_pay; }
    public Double getAbsent_days() { return this.absent_days; }
    public Double getPayment_days() { return this.payment_days; }
    public Double getTotal_working_hours() { return this.total_working_hours; }
    public Double getHour_rate() { return this.hour_rate; }
    public Double getBase_hour_rate() { return this.base_hour_rate; }
    public Double getGross_pay() { return this.gross_pay; }
    public Double getBase_gross_pay() { return this.base_gross_pay; }
    public Double getGross_year_to_date() { return this.gross_year_to_date; }
    public Double getBase_gross_year_to_date() { return this.base_gross_year_to_date; }
    public Double getTotal_deduction() { return this.total_deduction; }
    public Double getBase_total_deduction() { return this.base_total_deduction; }
    public Double getNet_pay() { return this.net_pay; }
    public Double getBase_net_pay() { return this.base_net_pay; }
    public Double getRounded_total() { return this.rounded_total; }
    public Double getBase_rounded_total() { return this.base_rounded_total; }
    public Double getYear_to_date() { return this.year_to_date; }
    public Double getBase_year_to_date() { return this.base_year_to_date; }
    public Double getMonth_to_date() { return this.month_to_date; }
    public Double getBase_month_to_date() { return this.base_month_to_date; }
    public String getTotal_in_words() { return this.total_in_words; }
    public String getBase_total_in_words() { return this.base_total_in_words; }
    public Double getCtc() { return this.ctc; }
    public Double getIncome_from_other_sources() { return this.income_from_other_sources; }
    public Double getTotal_earnings() { return this.total_earnings; }
    public Double getNon_taxable_earnings() { return this.non_taxable_earnings; }
    public Double getStandard_tax_exemption_amount() { return this.standard_tax_exemption_amount; }
    public Double getTax_exemption_declaration() { return this.tax_exemption_declaration; }
    public Double getDeductions_before_tax_calculation() { return this.deductions_before_tax_calculation; }
    public Double getAnnual_taxable_amount() { return this.annual_taxable_amount; }
    public Double getIncome_tax_deducted_till_date() { return this.income_tax_deducted_till_date; }
    public Double getCurrent_month_income_tax() { return this.current_month_income_tax; }
    public Double getFuture_income_tax_deductions() { return this.future_income_tax_deductions; }
    public Double getTotal_income_tax() { return this.total_income_tax; }
    public String getJournal_entry() { return this.journal_entry; }
    public String getAmended_from() { return this.amended_from; }
    public String getBank_name() { return this.bank_name; }
    public String getBank_account_no() { return this.bank_account_no; }


    public void setDeductions(List<Salary_Detail> deductions) { this.deductions = deductions; }
    public void setEarnings(List<Salary_Detail> earnings) { this.earnings = earnings; }
    public void setName(String name) { this.name = name; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }
    public void setModified_by(String modified_by) { this.modified_by = modified_by; }
    public void setDocstatus(Integer docstatus) { this.docstatus = docstatus; }
    public void setIdx(Integer idx) { this.idx = idx; }
    public void setEmployee(String employee) { this.employee = employee; }
    public void setEmployee_name(String employee_name) { this.employee_name = employee_name; }
    public void setCompany(String company) { this.company = company; }
    public void setDepartment(String department) { this.department = department; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setPosting_date(LocalDate posting_date) { this.posting_date = posting_date; }
    public void setLetter_head(String letter_head) { this.letter_head = letter_head; }
    public void setStatus(String status) { this.status = status; }
    public void setSalary_withholding(String salary_withholding) { this.salary_withholding = salary_withholding; }
    public void setSalary_withholding_cycle(String salary_withholding_cycle) { this.salary_withholding_cycle = salary_withholding_cycle; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setExchange_rate(Double exchange_rate) { this.exchange_rate = exchange_rate; }
    public void setPayroll_frequency(String payroll_frequency) { this.payroll_frequency = payroll_frequency; }
    public void setStart_date(LocalDate start_date) { this.start_date = start_date; }
    public void setEnd_date(LocalDate end_date) { this.end_date = end_date; }
    public void setSalary_structure(String salary_structure) { this.salary_structure = salary_structure; }
    public void setPayroll_entry(String payroll_entry) { this.payroll_entry = payroll_entry; }
    public void setMode_of_payment(String mode_of_payment) { this.mode_of_payment = mode_of_payment; }
    public void setSalary_slip_based_on_timesheet(Boolean salary_slip_based_on_timesheet) { this.salary_slip_based_on_timesheet = salary_slip_based_on_timesheet; }
    public void setDeduct_tax_for_unclaimed_employee_benefits(Boolean deduct_tax_for_unclaimed_employee_benefits) { this.deduct_tax_for_unclaimed_employee_benefits = deduct_tax_for_unclaimed_employee_benefits; }
    public void setDeduct_tax_for_unsubmitted_tax_exemption_proof( Boolean deduct_tax_for_unsubmitted_tax_exemption_proof) { this.deduct_tax_for_unsubmitted_tax_exemption_proof = deduct_tax_for_unsubmitted_tax_exemption_proof; }
    public void setTotal_working_days(Double total_working_days) { this.total_working_days = total_working_days; }
    public void setUnmarked_days(Double unmarked_days) { this.unmarked_days = unmarked_days; }
    public void setLeave_without_pay(Double leave_without_pay) { this.leave_without_pay = leave_without_pay; }
    public void setAbsent_days(Double absent_days) { this.absent_days = absent_days; }
    public void setPayment_days(Double payment_days) { this.payment_days = payment_days; }
    public void setTotal_working_hours(Double total_working_hours) { this.total_working_hours = total_working_hours; }
    public void setHour_rate(Double hour_rate) { this.hour_rate = hour_rate; }
    public void setBase_hour_rate(Double base_hour_rate) { this.base_hour_rate = base_hour_rate; }
    public void setGross_pay(Double gross_pay) { this.gross_pay = gross_pay; }
    public void setBase_gross_pay(Double base_gross_pay) { this.base_gross_pay = base_gross_pay; }
    public void setGross_year_to_date(Double gross_year_to_date) { this.gross_year_to_date = gross_year_to_date; }
    public void setBase_gross_year_to_date(Double base_gross_year_to_date) { this.base_gross_year_to_date = base_gross_year_to_date; }
    public void setTotal_deduction(Double total_deduction) { this.total_deduction = total_deduction; }
    public void setBase_total_deduction(Double base_total_deduction) { this.base_total_deduction = base_total_deduction; }
    public void setNet_pay(Double net_pay) { this.net_pay = net_pay; }
    public void setBase_net_pay(Double base_net_pay) { this.base_net_pay = base_net_pay; }
    public void setRounded_total(Double rounded_total) { this.rounded_total = rounded_total; }
    public void setBase_rounded_total(Double base_rounded_total) { this.base_rounded_total = base_rounded_total; }
    public void setYear_to_date(Double year_to_date) { this.year_to_date = year_to_date; }
    public void setBase_year_to_date(Double base_year_to_date) { this.base_year_to_date = base_year_to_date; }
    public void setMonth_to_date(Double month_to_date) { this.month_to_date = month_to_date; }
    public void setBase_month_to_date(Double base_month_to_date) { this.base_month_to_date = base_month_to_date; }
    public void setTotal_in_words(String total_in_words) { this.total_in_words = total_in_words; }
    public void setBase_total_in_words(String base_total_in_words) { this.base_total_in_words = base_total_in_words; }
    public void setCtc(Double ctc) { this.ctc = ctc; }
    public void setIncome_from_other_sources(Double income_from_other_sources) { this.income_from_other_sources = income_from_other_sources; }
    public void setTotal_earnings(Double total_earnings) { this.total_earnings = total_earnings; }
    public void setNon_taxable_earnings(Double non_taxable_earnings) { this.non_taxable_earnings = non_taxable_earnings; }
    public void setStandard_tax_exemption_amount(Double standard_tax_exemption_amount) { this.standard_tax_exemption_amount = standard_tax_exemption_amount; }
    public void setTax_exemption_declaration(Double tax_exemption_declaration) { this.tax_exemption_declaration = tax_exemption_declaration; }
    public void setDeductions_before_tax_calculation(Double deductions_before_tax_calculation) { this.deductions_before_tax_calculation = deductions_before_tax_calculation; }
    public void setAnnual_taxable_amount(Double annual_taxable_amount) { this.annual_taxable_amount = annual_taxable_amount; }
    public void setIncome_tax_deducted_till_date(Double income_tax_deducted_till_date) { this.income_tax_deducted_till_date = income_tax_deducted_till_date; }
    public void setCurrent_month_income_tax(Double current_month_income_tax) { this.current_month_income_tax = current_month_income_tax; }
    public void setFuture_income_tax_deductions(Double future_income_tax_deductions) { this.future_income_tax_deductions = future_income_tax_deductions; }
    public void setTotal_income_tax(Double total_income_tax) { this.total_income_tax = total_income_tax; }
    public void setJournal_entry(String journal_entry) { this.journal_entry = journal_entry; }
    public void setAmended_from(String amended_from) { this.amended_from = amended_from; }
    public void setBank_name(String bank_name) { this.bank_name = bank_name; }
    public void setBank_account_no(String bank_account_no) { this.bank_account_no = bank_account_no; }
}
