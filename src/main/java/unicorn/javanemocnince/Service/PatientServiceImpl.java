package unicorn.javanemocnince.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicorn.javanemocnince.Models.Patient;
import unicorn.javanemocnince.Repo.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;
    @Override
    public void addOperation(String operation) {

    }

    @Override
    public Iterable<Patient> listPatients() {
        return patientRepository.findAll();
    }
}
