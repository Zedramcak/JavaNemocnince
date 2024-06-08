package unicorn.javanemocnince.Service;


import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Specialization;
import unicorn.javanemocnince.Models.OperatingRoom;

public interface OperatingRoomService {
    void isFree();
    void addSpecialization(Specialization specialization);
    void addAllowedDoctor(Doctor doctor);

    Iterable<OperatingRoom> listOperatingRooms();

    OperatingRoom addOperatingRoom(OperatingRoom OperatingRoom);

    OperatingRoom updateOperatingRoom(Long id, OperatingRoom updatedOperatingRoom);

    void deleteOperatingRoom(Long id);

    OperatingRoom getOperatingRoom(Long id);
}