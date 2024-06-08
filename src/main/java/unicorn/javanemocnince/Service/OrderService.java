package unicorn.javanemocnince.Service;

import unicorn.javanemocnince.Models.Order;

public interface OrderService {

    public Iterable<Order> listOrders();

    Order addOrder(Order order);

    Order updateOrder(Long id, Order updatedOrder);

    void deleteOrder(Long id);

    Order getOrder(Long id);
}
