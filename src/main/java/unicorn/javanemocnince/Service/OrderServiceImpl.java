package unicorn.javanemocnince.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicorn.javanemocnince.Errors.OrderNotFoundException;
import unicorn.javanemocnince.Models.Order;
import unicorn.javanemocnince.Repo.OrderRepository;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Iterable<Order> listOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);

        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();
            existingOrder.setIdDoctor(updatedOrder.getIdDoctor());
            existingOrder.setIdPatient(updatedOrder.getIdPatient());
            existingOrder.setIdOperatingRoom(updatedOrder.getIdOperatingRoom());
            // Update other fields as needed

            return orderRepository.save(existingOrder);
        } else {
            throw new OrderNotFoundException("Objednávka s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);

        if (existingOrderOptional.isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException("Objednávka s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public Order getOrder(Long id) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);

        if (existingOrderOptional.isPresent()) {
            return existingOrderOptional.get();
        } else {
            throw new OrderNotFoundException("Objednávka s ID " + id + " nebyl nalezen.");
        }
    }
}
