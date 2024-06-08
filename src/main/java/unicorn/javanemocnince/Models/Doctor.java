package unicorn.javanemocnince.Models;

import lombok.Getter;
import lombok.Setter;
import unicorn.javanemocnince.Models.Enums.Specialization;

import java.util.ArrayList;

@Getter
@Setter
public class Doctor {
    private String id;
    private String name;
    private ArrayList<Specialization> specializations;
    private ArrayList<String> times;
    private ArrayList<String> occupiedTime;

}
