package unicorn.javanemocnince.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicorn.javanemocnince.Models.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
