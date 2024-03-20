package models.services;

import models.entities.Contract;
import models.entities.Installment;

import java.util.Scanner;

public class ContractService {

    private final OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        for (int i = 0; i < months; i++) {
            double installmentValue = contract.getTotalValue() / months;
            double paymentfee = onlinePaymentService.paymentFee(installmentValue);
            double interest = onlinePaymentService.interes(installmentValue + paymentfee, i + 1);
            contract.getInstallment().add(new Installment(contract.getDate().plusMonths(i + 1),
                    contract.getTotalValue() / months + paymentfee + interest));
        }
    }
}
