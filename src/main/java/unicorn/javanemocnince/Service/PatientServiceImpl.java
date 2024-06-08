package unicorn.javanemocnince.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicorn.javanemocnince.Errors.PatientNotFoundException;
import unicorn.javanemocnince.Models.Patient;
import unicorn.javanemocnince.Repo.PatientRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatientOptional = patientRepository.findById(id);

        if (existingPatientOptional.isPresent()) {
            Patient existingPatient = existingPatientOptional.get();
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setSurname(updatedPatient.getSurname());
            existingPatient.setInsurance(updatedPatient.getInsurance());
            // Update other fields as needed

            return patientRepository.save(existingPatient);
        } else {
            throw new PatientNotFoundException("Pacient s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public void deletePatient(Long id) {
        Optional<Patient> existingPatientOptional = patientRepository.findById(id);

        if (existingPatientOptional.isPresent()) {
            patientRepository.deleteById(id);
        } else {
            throw new PatientNotFoundException("Pacient s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public Patient getPatient(Long id) {
        Optional<Patient> existingPatientOptional = patientRepository.findById(id);

        if (existingPatientOptional.isPresent()) {
            return existingPatientOptional.get();
        } else {
            throw new PatientNotFoundException("Pacient s ID " + id + " nebyl nalezen.");
        }
    }
}
