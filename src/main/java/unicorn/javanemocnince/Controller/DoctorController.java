package unicorn.javanemocnince.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicorn.javanemocnince.Models.Doctor;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @GetMapping(value = "/")
    public Doctor getDoctor(String id){
        return new Doctor();
    }
}
