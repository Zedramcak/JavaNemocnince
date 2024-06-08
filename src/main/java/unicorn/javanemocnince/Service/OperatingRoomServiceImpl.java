package unicorn.javanemocnince.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicorn.javanemocnince.Errors.OperatingRoomNotFoundException;
import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.Specialization;
import unicorn.javanemocnince.Models.OperatingRoom;
import unicorn.javanemocnince.Repo.OperatingRoomRepository;

import java.util.Optional;

@Service
public class OperatingRoomServiceImpl implements OperatingRoomService{
    
    @Autowired
    OperatingRoomRepository operatingRoomRepository;

    
    public void isFree(){

    }
    public void addSpecialization(Specialization specialization){

    }
    public void addAllowedDoctor(Doctor doctor){

    }

    @Override
    public Iterable<OperatingRoom> listOperatingRooms() {
        return operatingRoomRepository.findAll();
    }

    @Override
    public OperatingRoom addOperatingRoom(OperatingRoom operatingRoom) {
        return operatingRoomRepository.save(operatingRoom);
    }

    @Override
    public OperatingRoom updateOperatingRoom(Long id, OperatingRoom updatedOperatingRoom) {
        Optional<OperatingRoom> existingOperatingRoomOptional = operatingRoomRepository.findById(id);

        if (existingOperatingRoomOptional.isPresent()) {
            OperatingRoom existingOperatingRoom = existingOperatingRoomOptional.get();
            existingOperatingRoom.setTitle(updatedOperatingRoom.getTitle());
            existingOperatingRoom.setIdspecializations(updatedOperatingRoom.getIdspecializations());

            return operatingRoomRepository.save(existingOperatingRoom);
        } else {
            throw new OperatingRoomNotFoundException("Pacient s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public void deleteOperatingRoom(Long id) {
        Optional<OperatingRoom> existingOperatingRoomOptional = operatingRoomRepository.findById(id);

        if (existingOperatingRoomOptional.isPresent()) {
            operatingRoomRepository.deleteById(id);
        } else {
            throw new OperatingRoomNotFoundException("Pacient s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public OperatingRoom getOperatingRoom(Long id) {
        Optional<OperatingRoom> existingOperatingRoomOptional = operatingRoomRepository.findById(id);

        if (existingOperatingRoomOptional.isPresent()) {
            return existingOperatingRoomOptional.get();
        } else {
            throw new OperatingRoomNotFoundException("Pacient s ID " + id + " nebyl nalezen.");
        }
    }
}