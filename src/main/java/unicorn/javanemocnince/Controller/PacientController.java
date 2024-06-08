package unicorn.javanemocnince.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicorn.javanemocnince.Models.Pacient;

@RestController
@RequestMapping(value = "/pacient")
public class PacientController {

    @GetMapping(value = "/")
    public Pacient getDoctor(String id){
        return new Pacient();
    }
}
