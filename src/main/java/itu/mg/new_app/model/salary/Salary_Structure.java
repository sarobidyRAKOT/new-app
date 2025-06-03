package itu.mg.new_app.model.salary;

import java.time.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Salary_Structure {
    

    private String name;
    private String owner;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;
    private String modified_by;
    private int docstatus;
    private int idx;
    private String company;
    private String letter_head;
    private String is_active;
    private String is_default;
    private String currency;
    private String amended_from;
    private double leave_encashment_amount_per_day;
    private double max_benefits;
    private int salary_slip_based_on_timesheet;
    private String payroll_frequency;
    private String salary_component;
    private double hour_rate;
    private double total_earning;
    private double total_deduction;
    private double net_pay;
    private String mode_of_payment;
    private String payment_account;

    // Constructeur par défaut
    public Salary_Structure() {}


    public String getAmended_from() { return amended_from; }
    public double getTotal_earning() { return total_earning; }
    public String getCompany() { return company; }
    public LocalDateTime getCreation() { return creation; }
    public String getCurrency() { return currency; }
    public int getDocstatus() { return docstatus; }
    public double getHour_rate() { return hour_rate; }
    public int getIdx() { return idx; }
    public String getIs_active() { return is_active; }
    public String getIs_default() { return is_default; }
    public double getLeave_encashment_amount_per_day() { return leave_encashment_amount_per_day; }
    public String getLetter_head() { return letter_head; }
    public double getMax_benefits() { return max_benefits; }
    public String getMode_of_payment() { return mode_of_payment; }
    public LocalDateTime getModified() { return modified; }
    public String getModified_by() { return modified_by; }
    public String getName() { return name; }
    public double getNet_pay() { return net_pay; }
    public String getOwner() { return owner; }
    public String getPayment_account() { return payment_account; }
    public String getPayroll_frequency() { return payroll_frequency; }
    public String getSalary_component() { return salary_component; }
    public int getSalary_slip_based_on_timesheet() { return salary_slip_based_on_timesheet; }
    public double getTotal_deduction() { return total_deduction; }

    
    public void setAmended_from(String amended_from) { this.amended_from = amended_from; }
    public void setCompany(String company) { this.company = company; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    public void setHour_rate(double hour_rate) { this.hour_rate = hour_rate; }
    public void setIdx(int idx) { this.idx = idx; }
    public void setIs_active(String is_active) { this.is_active = is_active; }
    public void setIs_default(String is_default) { this.is_default = is_default; }
    public void setLeave_encashment_amount_per_day(double leave_encashment_amount_per_day) { this.leave_encashment_amount_per_day = leave_encashment_amount_per_day; }
    public void setLetter_head(String letter_head) { this.letter_head = letter_head; }
    public void setMax_benefits(double max_benefits) { this.max_benefits = max_benefits; }
    public void setMode_of_payment(String mode_of_payment) { this.mode_of_payment = mode_of_payment; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }
    public void setModified_by(String modified_by) { this.modified_by = modified_by; }
    public void setName(String name) { this.name = name; }
    public void setNet_pay(double net_pay) { this.net_pay = net_pay; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPayment_account(String payment_account) { this.payment_account = payment_account; }
    public void setPayroll_frequency(String payroll_frequency) { this.payroll_frequency = payroll_frequency; }
    public void setSalary_component(String salary_component) { this.salary_component = salary_component; }
    public void setSalary_slip_based_on_timesheet(int salary_slip_based_on_timesheet) { this.salary_slip_based_on_timesheet = salary_slip_based_on_timesheet; }
    public void setTotal_deduction(double total_deduction) { this.total_deduction = total_deduction; }
    public void setTotal_earning(double total_earning) { this.total_earning = total_earning; }
    


}
