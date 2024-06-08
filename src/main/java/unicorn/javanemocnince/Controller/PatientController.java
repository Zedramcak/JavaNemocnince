package unicorn.javanemocnince.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicorn.javanemocnince.Models.Patient;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @GetMapping(value = "/")
    public Patient getPatient(String id){
        return new Patient();
    }
}
