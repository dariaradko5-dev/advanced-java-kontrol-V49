package VO;

import java.util.Arrays;

public class Order {
        private final String id;
        private final String email;
        private OrderStatus status;
        private Money totalAmount;
        private OrderItem[] items;

        public Order(String id, String email, OrderStatus status, Money totalAmount, OrderItem[] items) {
            this.id = id;
            this.email = email;
            this.status = status;
            this.totalAmount = totalAmount;
            this.items = (items == null) ? new OrderItem[0] : Arrays.copyOf(items, items.length);
        }
public Order(String id, String customerId, OrderItem[] items){
            this(id, customerId,OrderStatus.NEW, new Money(0), items);
}
        public String getId() {
            return id;
        }

        public String getCustomerId() {
            return email;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public Money getTotalAmount() {
            return totalAmount;
        }
    public OrderItem[] getItems() {
        return Arrays.copyOf(items, items.length);
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotalAmount(Money money) {
        this.totalAmount = money;
    }
}
