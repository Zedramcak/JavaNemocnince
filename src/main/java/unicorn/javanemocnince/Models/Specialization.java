package unicorn.javanemocnince.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Specialization {
    @Id
    @SequenceGenerator(name = "spec_seq", sequenceName = "spec_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "spec_seq")
    private Long id;
    private String name;
}
