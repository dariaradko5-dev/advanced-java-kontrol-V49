
import VO.*;
import service.*;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class FindByIdTest {


    OrderProcessor processor = new OrderProcessor();

    @Test
    void testFindById() {
        Order order1 = new Order("ID_1", "user1", new OrderItem[]{});
        Order order2 = new Order("ID_2", "user2", new OrderItem[]{});
        Order[] db = {order1, order2};
        Optional<Order> found = processor.findById(db, "ID_2");

        assertTrue(found.isPresent());
        assertEquals("ID_2", found.get().getId());
    }
}
