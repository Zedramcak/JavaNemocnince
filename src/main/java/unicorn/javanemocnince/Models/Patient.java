package unicorn.javanemocnince.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Patient {
    private String id;
    private String firstName;
    private String lastName;
    private String insurance;
    private ArrayList<String> operations;
}
