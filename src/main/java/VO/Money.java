package VO;

import java.util.Objects;

public class Money {
private final double amount;

    public Money(double amount) {
        this.amount = amount;
    }
    public Money() {
        this(0.0);
    }
    public double getAmount() {
        return amount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
