package service;

import VO.Order;
import VO.OrderStatus;
import exception.ArchiveOperationException;

import java.util.Optional;

public class OrderProcessor extends OrderProcessorTemplate {
    @Override
    protected void pay(Order order, PaymentMethod method) {
        method.pay(order.getTotalAmount());
        order.setStatus(OrderStatus.PAID);
    }

    @Override
    protected void archiveAfterDelivery(Order order) {
        if (order.getStatus() != OrderStatus.DELIVERED) {
            throw new ArchiveOperationException("Cannot archive order " + order.getId() + " because it is not delivered yet.");
        }
        order.setStatus(OrderStatus.ARCHIVED);
    }
    public Optional<Order> findById(Order[] ordersDb, String idToFind) {
        if (ordersDb == null || idToFind == null) {
            return Optional.empty();
        }
        for (Order order : ordersDb) {
            if (order.getId().equals(idToFind)) {
                return Optional.of(order);
            }
        }

        return Optional.empty();
    }
}
