package unicorn.javanemocnince.Service;

import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Specialization;

import java.util.List;

public interface DoctorService {

    List<Doctor> getDoctorsBySpecialization(Specialization specialization);
    Doctor Doctor(Doctor doctor);

    public Iterable<Doctor> listDoctors();

    Doctor addDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor updatedDoctor);

    void deleteDoctor(Long id);

    Doctor getDoctor(Long id);
}
