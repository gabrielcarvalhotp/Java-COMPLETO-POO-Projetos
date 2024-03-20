package models.services;

public interface OnlinePaymentService {

    public Double paymentFee(Double amount);
    public Double interes(Double amount, Integer months);
}
