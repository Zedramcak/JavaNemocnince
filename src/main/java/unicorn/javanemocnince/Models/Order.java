package unicorn.javanemocnince.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "order_seq")
    private Long id;
    @OneToOne
    @JoinColumn(name="idpatient", referencedColumnName="id")
    private Patient idPatient;
    @OneToOne
    @JoinColumn(name="iddoctor", referencedColumnName="id")
    private Doctor idDoctor;
    @OneToOne
    @JoinColumn(name="idoperatingroom", referencedColumnName="id")
    private OperatingRoom idOperatingRoom;
    private String workingtime;

}
