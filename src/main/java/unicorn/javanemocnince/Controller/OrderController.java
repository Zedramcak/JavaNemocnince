package unicorn.javanemocnince.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicorn.javanemocnince.Errors.OrderNotFoundException;
import unicorn.javanemocnince.Models.NewOrder;
import unicorn.javanemocnince.Models.Order;
import unicorn.javanemocnince.Service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        try {
            Order order = orderService.getOrder(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (OrderNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/list")
    public Iterable<Order> listOrders(){
        return orderService.listOrders();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Order> addOrder(@RequestBody NewOrder newOrder){
        Order newOrder = orderService.addOrder(newOrder);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        try {
            Order updatedOrder = orderService.updateOrder(id, order);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
