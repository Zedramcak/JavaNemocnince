package unicorn.javanemocnince.Service;

import unicorn.javanemocnince.Models.Patient;

import java.util.List;

public interface PatientService {
    void addOperation(String operation);

    public Iterable<Patient> listPatients();
}
