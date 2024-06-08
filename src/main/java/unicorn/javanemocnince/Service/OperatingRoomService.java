package unicorn.javanemocnince.Service;


import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Specialization;
import unicorn.javanemocnince.Models.OperatingRoom;

import java.util.List;

public interface OperatingRoomService {

    Iterable<OperatingRoom> listOperatingRooms();

    OperatingRoom addOperatingRoom(OperatingRoom OperatingRoom);

    OperatingRoom updateOperatingRoom(Long id, OperatingRoom updatedOperatingRoom);

    void deleteOperatingRoom(Long id);

    OperatingRoom getOperatingRoom(Long id);

    List<OperatingRoom> findBySpecialization(Specialization specialization);
}