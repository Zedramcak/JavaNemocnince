package unicorn.javanemocnince.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicorn.javanemocnince.Models.OperatingRoom;

@Repository
public interface OperatingRoomRepository extends CrudRepository<OperatingRoom, Long> {
}
