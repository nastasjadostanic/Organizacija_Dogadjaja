package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.ShipHistoryAppointment;
import stasaaleksadavid.isabackend.repository.ShipHistoryAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ShipHistoryAppointmentController {
    @Autowired
    private ShipHistoryAppointmentRepository shipHistoryAppointmentRepository;


    //get all

    @GetMapping("/shiphistoryappointments")
    public List<ShipHistoryAppointment> getAllShipHistoryAppointments() {
        return shipHistoryAppointmentRepository.findAll();
    }

    //create
    @PostMapping("/shiphistoryappointments")
    public ShipHistoryAppointment createShipHistoryAppointment(@RequestBody ShipHistoryAppointment shipHistoryAppointment) {
        return shipHistoryAppointmentRepository.save(shipHistoryAppointment);
    }

    //get by id
    @GetMapping("/shiphistoryappointments/{id}")
    public ResponseEntity<ShipHistoryAppointment> getShipHistoryAppointmentById(@PathVariable Long id) {
        ShipHistoryAppointment shipHistoryAppointment = shipHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipHistoryAppointment does not exist with id:" + id));
        return ResponseEntity.ok(shipHistoryAppointment);
    }

    //update
    @PutMapping("/shiphistoryappointments/{id}")
    public ResponseEntity<ShipHistoryAppointment> updateShipHistoryAppointment(@PathVariable Long id, @RequestBody ShipHistoryAppointment shipHistoryAppointmentDetails) {
        ShipHistoryAppointment shipHistoryAppointment = shipHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipHistoryAppointment does not exist with id:" + id));

        shipHistoryAppointment.setShipId(shipHistoryAppointmentDetails.getShipId());
        shipHistoryAppointment.setStartingDate(shipHistoryAppointmentDetails.getStartingDate());
        shipHistoryAppointment.setEndingDate(shipHistoryAppointmentDetails.getEndingDate());
        shipHistoryAppointment.setNumberOfPeople(shipHistoryAppointmentDetails.getNumberOfPeople());
        shipHistoryAppointment.setAdditionalServices(shipHistoryAppointmentDetails.getAdditionalServices());
        shipHistoryAppointment.setPrice(shipHistoryAppointmentDetails.getPrice());
        shipHistoryAppointment.setClientId(shipHistoryAppointmentDetails.getClientId());


        ShipHistoryAppointment updatedShipHistoryAppointment = shipHistoryAppointmentRepository.save(shipHistoryAppointment);
        return ResponseEntity.ok(updatedShipHistoryAppointment);
    }


    //delete
    @DeleteMapping("/shiphistoryappointments/{id}")
    public Map<String, Boolean> deleteShipHistoryAppointment(@PathVariable Long id) {

        ShipHistoryAppointment shipHistoryAppointment = shipHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipHistoryAppointment does not exist with id:" + id));

        shipHistoryAppointmentRepository.delete(shipHistoryAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    @GetMapping("/shiphistoryappointments/ship/{type}/{shipid}")
    public List<ShipHistoryAppointment> getHistoryAppointmentByShipId(@PathVariable String type,@PathVariable Long shipid) {
        if(type.equals("admin") || type.equals("main_admin")||type.equals("ship_owner")) {
            return shipHistoryAppointmentRepository.findByShipId(shipid);
        }
        else return null;
    }
}
