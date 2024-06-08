package unicorn.javanemocnince.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "patient_seq")
    private Long id;
    private String name;
    private String surname;
    private String insurance;
}
