package unicorn.javanemocnince.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Specialization;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    public List<Doctor> findAllByIdspecialization(Specialization specialization);
}
