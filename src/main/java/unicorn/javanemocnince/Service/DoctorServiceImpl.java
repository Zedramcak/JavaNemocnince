package unicorn.javanemocnince.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicorn.javanemocnince.Errors.DoctorNotFoundException;
import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Enums.Specialization;
import unicorn.javanemocnince.Repo.DoctorRepository;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    @Override
    public Doctor Doctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Iterable listDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Optional<Doctor> existingDoctorOptional = doctorRepository.findById(id);

        if (existingDoctorOptional.isPresent()) {
            Doctor existingDoctor = existingDoctorOptional.get();
            existingDoctor.setName(updatedDoctor.getName());
            existingDoctor.setIdspecialization(updatedDoctor.getIdspecialization());
            existingDoctor.setShifts(updatedDoctor.getShifts());

            return doctorRepository.save(existingDoctor);
        } else {
            throw new DoctorNotFoundException("Doktor s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public void deleteDoctor(Long id) {
        Optional<Doctor> existingDoctorOptional = doctorRepository.findById(id);

        if (existingDoctorOptional.isPresent()) {
            doctorRepository.deleteById(id);
        } else {
            throw new DoctorNotFoundException("Doktor s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public Doctor getDoctor(Long id) {
        Optional<Doctor> existingDoctorOptional = doctorRepository.findById(id);

        if (existingDoctorOptional.isPresent()) {
            return existingDoctorOptional.get();
        } else {
            throw new DoctorNotFoundException("Doktor s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public void addSpecialization(String doctorId, Specialization specialization) {

    }

    @Override
    public void addWorkingTime(String doctorId, String workingTime) {

    }
}