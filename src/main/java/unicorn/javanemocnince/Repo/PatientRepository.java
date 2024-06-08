package unicorn.javanemocnince.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicorn.javanemocnince.Models.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
