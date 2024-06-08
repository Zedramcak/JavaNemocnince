package unicorn.javanemocnince.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicorn.javanemocnince.Errors.DoctorNotFoundException;
import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Service.DoctorService;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id){
        try {
            Doctor doctor = doctorService.getDoctor(id);
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (DoctorNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/list")
    public Iterable<Doctor> listDoctors(){
        return doctorService.listDoctors();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        Doctor newDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
            return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        try {
            doctorService.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}