package unicorn.javanemocnince.Service;

import unicorn.javanemocnince.Models.Patient;

import java.util.List;

public interface PatientService {
    void addOperation(String operation);

    public Iterable<Patient> listPatients();

    Patient addPatient(Patient patient);

    Patient updatePatient(Long id, Patient updatedPatient);

    void deletePatient(Long id);

    Patient getPatient(Long id);
}
