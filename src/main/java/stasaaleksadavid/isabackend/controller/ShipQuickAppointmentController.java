package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.ShipQuickAppointment;
import stasaaleksadavid.isabackend.repository.ShipQuickAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ShipQuickAppointmentController {

    @Autowired
    private ShipQuickAppointmentRepository shipQuickAppointmentRepository;

    //get all

    @GetMapping("/shipquickappointments")
    public List<ShipQuickAppointment> getAllShipQuickAppointments() {
        return shipQuickAppointmentRepository.findAll();
    }

    //create
    @PostMapping("/shipquickappointments/{type}")
    public ShipQuickAppointment createShipQuickAppointment(@PathVariable String type,@RequestBody ShipQuickAppointment shipQuickAppointment) {
        if (type.equals("ship_owner") || type.equals("admin") || type.equals("main_admin")) {
            return shipQuickAppointmentRepository.save(shipQuickAppointment);
        }
        else return null;
    }

    //get by id
    @GetMapping("/shipquickappointments/{id}")
    public ResponseEntity<ShipQuickAppointment> getShipQuickAppointmentById(@PathVariable Long id) {
        ShipQuickAppointment shipQuickAppointment = shipQuickAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipQuickAppointment does not exist with id:" + id));
        return ResponseEntity.ok(shipQuickAppointment);
    }

    //update
    @PutMapping("/shipquickappointments/{id}")
    public ResponseEntity<ShipQuickAppointment> updateShipQuickAppointment(@PathVariable Long id, @RequestBody ShipQuickAppointment shipQuickAppointmentDetails) {
        ShipQuickAppointment shipQuickAppointment = shipQuickAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipQuickAppointment does not exist with id:" + id));


        shipQuickAppointment.setShipId(shipQuickAppointmentDetails.getShipId());
        shipQuickAppointment.setStartingDate(shipQuickAppointmentDetails.getStartingDate());
        shipQuickAppointment.setEndingDate(shipQuickAppointmentDetails.getEndingDate());
        shipQuickAppointment.setNumberOfPeople(shipQuickAppointmentDetails.getNumberOfPeople());
        shipQuickAppointment.setAdditionalServices(shipQuickAppointmentDetails.getAdditionalServices());
        shipQuickAppointment.setPrice(shipQuickAppointmentDetails.getPrice());


        ShipQuickAppointment updatedShipQuickAppointment = shipQuickAppointmentRepository.save(shipQuickAppointment);
        return ResponseEntity.ok(updatedShipQuickAppointment);
    }


    //delete
    @DeleteMapping("/shipquickappointments/{id}")
    public Map<String, Boolean> deleteShipQuickAppointment(@PathVariable Long id) {

        ShipQuickAppointment shipQuickAppointment = shipQuickAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipQuickAppointment does not exist with id:" + id));

        shipQuickAppointmentRepository.delete(shipQuickAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }


    @GetMapping("/shipquickappointments/ship/{type}/{shipid}")
    public List<ShipQuickAppointment> getAppointmentByShipId(@PathVariable String type,@PathVariable Long shipid) {
        if (type.equals("ship_owner") || type.equals("admin") || type.equals("main_admin")){
            return shipQuickAppointmentRepository.findByShipId(shipid);
    }
    else return null;
    }
}
