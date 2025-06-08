package itu.mg.new_app.model.Utils;

import java.util.ArrayList;
import java.util.List;

public class Graphe {
    
    private List <Double> total_salary = new ArrayList<>();
    private List <Double> total_earnings = new ArrayList<>();
    private List <Double> total_deductions = new ArrayList<>();
    private List <Double> gross_pay = new ArrayList<>();

    public Graphe () {}

    public List<Double> getGross_pay() {
        return gross_pay;
    }
    public void setGross_pay(List<Double> gross_pay) {
        this.gross_pay = gross_pay;
    }
    public List<Double> getTotal_deductions() { return total_deductions; }
    public List<Double> getTotal_earnings() { return total_earnings; }
    public List<Double> getTotal_salary() { return total_salary; }
    public void setTotal_deductions(List<Double> total_deductions) { this.total_deductions = total_deductions; }
    public void setTotal_earnings(List<Double> total_earnings) { this.total_earnings = total_earnings; }
    public void setTotal_salary(List<Double> total_salary) { this.total_salary = total_salary; }
}
