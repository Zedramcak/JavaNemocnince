package unicorn.javanemocnince.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "operatingroom")
public class OperatingRoom{

    @Id
    @SequenceGenerator(name = "room_seq", sequenceName = "room_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "room_seq")
    private Long id;
    private String title;
    @OneToOne
    @JoinColumn(name="idspecialization", referencedColumnName="id")
    private Specialization idspecializations;

}