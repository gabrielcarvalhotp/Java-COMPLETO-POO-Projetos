package models.services;

public class PaypalService implements OnlinePaymentService{

    public Double paymentFee(Double amount) {
        Double tax = 0.02;
        return amount * tax;
    }

    public Double interes(Double amount, Integer months) {
        Double interest = 0.01;
        return amount * (interest * months);
    }

}
