package entities;

public class Employee {
    private String name;
    private double grossSalary;
    private double tax;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGrossSalary() {
        return grossSalary;
    }
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public double netSalary() {
        return this.grossSalary - this.tax;
    }
    public void increaseSalary(double percentege) {
        this.grossSalary = this.grossSalary + (this.grossSalary * (percentege / 100));
    }

    public String toString(){
        return String.format("Employee: %s, $ %f", this.name, this.netSalary());
    }

}
