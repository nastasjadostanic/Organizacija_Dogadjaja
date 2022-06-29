package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Room;
import stasaaleksadavid.isabackend.repository.RoomRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    //get all

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){return roomRepository.findAll();}

    //create
    @PostMapping("/rooms/{type}")
    public  Room createRoom(@PathVariable String type,@RequestBody Room room){
        if ( type.equals("admin") || type.equals("cottage_owner") || type.equals("main_admin")) {
            return roomRepository.save(room);
        }
        else return null;
    }

    //get by id
    @GetMapping("/rooms/{type}/{id}")
    public ResponseEntity <Room> getRoomById(@PathVariable String type,@PathVariable Long id){
        if ( type.equals("admin") || type.equals("cottage_owner") || type.equals("main_admin")) {
            Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room does not exist with id:" + id));
            return ResponseEntity.ok(room);
        }
        else return null;
    }

    //update
    @PutMapping("/rooms/{type}/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable String type,@PathVariable Long id,@RequestBody Room roomDetails){
        if ( type.equals("admin") || type.equals("cottage_owner") || type.equals("main_admin")) {
            Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room does not exist with id:" + id));


            room.setNumber(roomDetails.getNumber());
            room.setNumberOfBeds(roomDetails.getNumberOfBeds());
            room.setDescription(roomDetails.getDescription());

            Room updatedRoom = roomRepository.save(room);
            return ResponseEntity.ok(updatedRoom);
        }
        else return null;
    }


    //delete
    @DeleteMapping("/rooms/{type}/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable Long id,@PathVariable String type) {
        if (type.equals("ship_owner") || type.equals("admin") || type.equals("cottage_owner") || type.equals("fishing_instructor") || type.equals("main_admin")) {
            Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room does not exist with id:" + id));

            roomRepository.delete(room);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else return null;
    }

//get by cottage id
    @GetMapping("/rooms/cottage/{type}/{cottageid}")
    public List<Room> getRoomByCottageId(@PathVariable String type,@PathVariable Long cottageid){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")){
        return roomRepository.findByCottageId(cottageid);
    }
        else return null;
    }
}
