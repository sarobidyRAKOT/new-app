package itu.mg.new_app.model.salary;

import java.util.List;


public class Salary_Slip_Total {
    
    private double gross_pay;
    private double deduction;
    private double net_pay;
    private String currency = "EUR";

    public Salary_Slip_Total () {}

    public double getDeduction() { return deduction; }
    public double getGross_pay() { return gross_pay; }
    public double getNet_pay() { return net_pay; }

    public void setDeduction(double deduction) { this.deduction = deduction; }
    public void setGross_pay(double gross_pay) { this.gross_pay = gross_pay; }
    public void setNet_pay(double net_pay) { this.net_pay = net_pay; }

    
    public static Salary_Slip_Total calculer (List <Salary_Slip> salary_Slips) {
        if (salary_Slips == null) {
            return new Salary_Slip_Total();
        }
        Salary_Slip_Total salary_Slip_Total = new Salary_Slip_Total();
        
        for (Salary_Slip salary_Slip : salary_Slips) {
            
            salary_Slip_Total.gross_pay += salary_Slip.getGross_pay();
            salary_Slip_Total.deduction += salary_Slip.getTotal_deduction();
            salary_Slip_Total.net_pay += salary_Slip.getNet_pay();
        }
        return salary_Slip_Total;

    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
