package unicorn.javanemocnince.Service;

import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Enums.Specialization;

public interface DoctorService {
    void addSpecialization(Specialization specialization);
    void addWorkingTime(String workingTime);

    void addBusy(String timeBusy);

    Doctor getDoctorById(String id);
}
