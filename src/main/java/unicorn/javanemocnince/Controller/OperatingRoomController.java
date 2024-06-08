package unicorn.javanemocnince.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicorn.javanemocnince.Errors.OperatingRoomNotFoundException;
import unicorn.javanemocnince.Models.OperatingRoom;
import unicorn.javanemocnince.Service.OperatingRoomService;

@RestController
@RequestMapping(value = "/operatingRoom")
public class OperatingRoomController {


    @Autowired
    OperatingRoomService operatingRoomService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OperatingRoom> getOperatingRoom(@PathVariable Long id){
        try {
            OperatingRoom OperatingRoom = operatingRoomService.getOperatingRoom(id);
            return new ResponseEntity<>(OperatingRoom, HttpStatus.OK);
        } catch (OperatingRoomNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/list")
    public Iterable<OperatingRoom> listOperatingRooms(){
        return operatingRoomService.listOperatingRooms();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<OperatingRoom> addOperatingRoom(@RequestBody OperatingRoom OperatingRoom){
        OperatingRoom newOperatingRoom = operatingRoomService.addOperatingRoom(OperatingRoom);
        return new ResponseEntity<>(newOperatingRoom, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<OperatingRoom> updateOperatingRoom(@PathVariable Long id, @RequestBody OperatingRoom OperatingRoom) {
        try {
            OperatingRoom updatedOperatingRoom = operatingRoomService.updateOperatingRoom(id, OperatingRoom);
            return new ResponseEntity<>(updatedOperatingRoom, HttpStatus.OK);
        } catch (OperatingRoomNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperatingRoom(@PathVariable Long id) {
        try {
            operatingRoomService.deleteOperatingRoom(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OperatingRoomNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}