package service;

import VO.Money;
import exception.PaymentException;

public class CardPayment implements PaymentMethod {
    @Override
    public void pay(Money amount) {
        if (amount.getAmount() > 20000) {
            throw new PaymentException("Card payment limit exceeded (max 20,000)");
        }
        System.out.println("Processing card payment of " + amount.getAmount());
    }
}
