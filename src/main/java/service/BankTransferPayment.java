package service;

import VO.Money;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void pay(Money amount) {
        double commission = amount.getAmount() * 0.01;
        double total = amount.getAmount() + commission;
        System.out.println("Processing bank transfer payment of " + amount.getAmount() + " with commission of " + commission + ", total: " + total);
    }
}