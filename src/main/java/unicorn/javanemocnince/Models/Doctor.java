package unicorn.javanemocnince.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import unicorn.javanemocnince.Models.Enums.Specialization;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer idspecialization;
    private String shifts;




}
