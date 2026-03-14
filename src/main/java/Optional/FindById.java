package Optional;

import VO.Order;

import java.util.Optional;

public class FindById {
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
