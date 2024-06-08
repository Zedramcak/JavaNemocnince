package unicorn.javanemocnince.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicorn.javanemocnince.Models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
