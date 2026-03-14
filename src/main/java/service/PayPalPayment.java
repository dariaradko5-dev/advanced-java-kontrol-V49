package service;

import VO.Money;
import exception.PaymentException;

public class PayPalPayment implements PaymentMethod{
    @Override
    public void pay(Money amount) {
        if (amount.getAmount() < 100) {
            throw new PaymentException("PayPal payment failed: minimum amount is 100");
        }
        System.out.println("Paid " + amount.getAmount() + " via PayPal.");
    }
    }

