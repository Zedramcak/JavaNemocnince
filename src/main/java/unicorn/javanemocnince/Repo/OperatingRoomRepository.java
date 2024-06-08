package unicorn.javanemocnince.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicorn.javanemocnince.Models.OperatingRoom;
import unicorn.javanemocnince.Models.Specialization;

import java.util.List;

@Repository
public interface OperatingRoomRepository extends CrudRepository<OperatingRoom, Long> {
    public List<OperatingRoom> findAllByIdspecializations(Specialization specialization);
}
