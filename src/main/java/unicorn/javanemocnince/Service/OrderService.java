package unicorn.javanemocnince.Service;

import unicorn.javanemocnince.Models.NewOrder;
import unicorn.javanemocnince.Models.Order;

public interface OrderService {

    public Iterable<Order> listOrders();

    Order addOrder(NewOrder newOrder);

    Order updateOrder(Long id, Order updatedOrder);

    void deleteOrder(Long id);

    Order getOrder(Long id);
}
