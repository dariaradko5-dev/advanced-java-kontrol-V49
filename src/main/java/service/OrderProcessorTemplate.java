package service;
import VO.*;
import exception.AppException;
import exception.ArchiveOperationException;

public abstract class OrderProcessorTemplate {
    public final void processOrder(Order order, PaymentMethod method){
        System.out.println("Starting order processing for order: " + order.getId());
        try {
            validate(order);
            calculateTotal(order);
            pay(order, method);
            order.setStatus(OrderStatus.DELIVERED);

            archiveAfterDelivery(order);
            ;
            System.out.println("Order processing completed for order: " + order.getId());
        } catch (AppException e) {
            System.out.println("WARN: Business error: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("ERROR: Unexpected error: " + e.getMessage());
            throw new AppException("An unexpected error occurred while processing the order", e);
        }
    }
        protected void validate(Order order) {
            for (OrderItem item : order.getItems()) {
                if (item.getPrice().getAmount() > 50000) {
                    throw new AppException("Validation failed: Item " + item.getName() + " price exceeds 50,000");
                }
            }
        }
        private void calculateTotal(Order order) {
            double total =0;
            for (OrderItem item : order.getItems()) {
                double price = item.getPrice().getAmount();
                if ("CLEARANCE".equalsIgnoreCase(item.getCategory())) {
                    price *= 0.8;
                }
                total+=price * item.getQuantity();
            }
            order.setTotalAmount(new Money(total));
        }
        protected abstract void pay(Order order, PaymentMethod method);
        protected abstract void archiveAfterDelivery(Order order)
        throws ArchiveOperationException;
    }

