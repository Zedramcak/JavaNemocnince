package unicorn.javanemocnince.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer idPatient;
    private Integer idDoctor;
    private Integer idOperatingRoom;

}
