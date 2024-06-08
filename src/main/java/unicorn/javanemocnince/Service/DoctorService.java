package unicorn.javanemocnince.Service;

import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Enums.Specialization;
import unicorn.javanemocnince.Models.Patient;

public interface DoctorService {
    void addSpecialization(String doctorId, Specialization specialization);
    void addWorkingTime(String doctorId, String workingTime);

    void addBusy(String doctorId, String timeBusy);

    Doctor Doctor(Doctor doctor);

    public Iterable<Doctor> listDoctors();

    Doctor addDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor updatedDoctor);

    void deleteDoctor(Long id);

    Doctor getDoctor(Long id);
}
