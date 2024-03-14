package entities;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double impost = 0.16;
        if (getNumberOfEmployees() > 10) {
            impost = 0.14;
        }
        return getAnualIncome() * impost;
    }
}
