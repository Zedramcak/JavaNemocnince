package unicorn.javanemocnince.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicorn.javanemocnince.Models.Patient;
import unicorn.javanemocnince.Service.PatientService;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/list")
    public Iterable<Patient> listPatients(){
        return patientService.listPatients();
    }
}
