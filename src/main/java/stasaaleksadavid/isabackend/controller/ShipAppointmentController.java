package stasaaleksadavid.isabackend.controller;
import stasaaleksadavid.isabackend.repository.ShipFreeAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.*;
import stasaaleksadavid.isabackend.repository.ShipAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ShipAppointmentController {
    @Autowired
    private ShipAppointmentRepository shipAppointmentRepository;

    @Autowired
    private ShipFreeAppointmentRepository shipFreeAppointmentRepository;

//get all

    @GetMapping("/shipappointments")
    public List<ShipAppointment> getAllShipAppointments() {
        return shipAppointmentRepository.findAll();
    }

    //create
    @PostMapping("/shipappointments/{type}")
    public ShipAppointment createShipAppointment(@PathVariable String type,@RequestBody ShipAppointment shipAppointment) {
        if (type.equals("ship_owner") || type.equals("admin") || type.equals("main_admin")) {
            List<ShipFreeAppointment> shipFreeAppointments = shipFreeAppointmentRepository.findByShipId(shipAppointment.getShipId());

            for (ShipFreeAppointment s : shipFreeAppointments) {
                if (shipAppointment.getStartingDate().isAfter(s.getStartingDate()) && shipAppointment.getEndingDate().isBefore(s.getEndingDate())) {

                    ShipFreeAppointment freeAppointment_1 = new ShipFreeAppointment(s.getShipId(), s.getStartingDate(), shipAppointment.getStartingDate(), s.getNumberOfPeople(), s.getAdditionalServices(), s.getPrice());
                    ShipFreeAppointment freeAppointment_2 = new ShipFreeAppointment(s.getShipId(), shipAppointment.getEndingDate(), s.getEndingDate(), s.getNumberOfPeople(), s.getAdditionalServices(), s.getPrice());
                    ShipAppointment newShipAppointment = new ShipAppointment(shipAppointment.getShipId(), shipAppointment.getClientId(), shipAppointment.getStartingDate(), shipAppointment.getEndingDate(), shipAppointment.getNumberOfPeople(), shipAppointment.getAdditionalServices(), shipAppointment.getPrice());

                    shipFreeAppointmentRepository.deleteById(s.getId());
                    shipFreeAppointmentRepository.save(freeAppointment_1);
                    shipFreeAppointmentRepository.save(freeAppointment_2);

                    return shipAppointmentRepository.save(newShipAppointment);
                } else if (shipAppointment.getStartingDate().isAfter(s.getStartingDate()) && shipAppointment.getEndingDate().isAfter(s.getEndingDate())) {
                    ShipFreeAppointment freeAppointment_1 = new ShipFreeAppointment(s.getShipId(), s.getStartingDate(), shipAppointment.getStartingDate(), s.getNumberOfPeople(), s.getAdditionalServices(), s.getPrice());
                    ShipAppointment newShipAppointment = new ShipAppointment(shipAppointment.getShipId(), shipAppointment.getClientId(), shipAppointment.getStartingDate(), s.getEndingDate(), shipAppointment.getNumberOfPeople(), s.getAdditionalServices(), s.getPrice());
                    shipFreeAppointmentRepository.deleteById(s.getId());
                    shipFreeAppointmentRepository.save(freeAppointment_1);

                    return shipAppointmentRepository.save(newShipAppointment);
                } else if (shipAppointment.getStartingDate().isBefore(s.getStartingDate()) && shipAppointment.getEndingDate().isBefore(s.getEndingDate())) {
                    ShipFreeAppointment freeAppointment_1 = new ShipFreeAppointment(s.getShipId(), shipAppointment.getEndingDate(), s.getEndingDate(), s.getNumberOfPeople(), s.getAdditionalServices(), s.getPrice());
                    ShipAppointment newShipAppointment = new ShipAppointment(shipAppointment.getShipId(), shipAppointment.getClientId(), s.getStartingDate(), shipAppointment.getEndingDate(), shipAppointment.getNumberOfPeople(), shipAppointment.getAdditionalServices(), shipAppointment.getPrice());

                    shipFreeAppointmentRepository.deleteById(s.getId());
                    shipFreeAppointmentRepository.save(freeAppointment_1);

                    return shipAppointmentRepository.save(newShipAppointment);
                } else if (shipAppointment.getStartingDate().isBefore(s.getStartingDate()) && shipAppointment.getEndingDate().isAfter(s.getEndingDate())) {

                    return null;
                }
            }

            return shipAppointmentRepository.save(shipAppointment);
        }
        else return null;
    }

    //get by id
    @GetMapping("/shipappointments/{id}")
    public ResponseEntity<ShipAppointment> getShipAppointmentById(@PathVariable Long id) {
        ShipAppointment shipAppointment = shipAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipAppointment does not exist with id:" + id));
        return ResponseEntity.ok(shipAppointment);
    }

    //update
    @PutMapping("/shipappointments/{id}")
    public ResponseEntity<ShipAppointment> updateShipAppointment(@PathVariable Long id, @RequestBody ShipAppointment shipAppointmentDetails) {
        ShipAppointment shipAppointment = shipAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipAppointment does not exist with id:" + id));

        shipAppointment.setClientId(shipAppointmentDetails.getClientId());
        shipAppointment.setShipId(shipAppointmentDetails.getShipId());
        shipAppointment.setStartingDate(shipAppointmentDetails.getStartingDate());
        shipAppointment.setEndingDate(shipAppointmentDetails.getEndingDate());
        shipAppointment.setNumberOfPeople(shipAppointmentDetails.getNumberOfPeople());
        shipAppointment.setAdditionalServices(shipAppointmentDetails.getAdditionalServices());
        shipAppointment.setPrice(shipAppointmentDetails.getPrice());


        ShipAppointment updatedShipAppointment = shipAppointmentRepository.save(shipAppointment);
        return ResponseEntity.ok(updatedShipAppointment);
    }


    //delete
    @DeleteMapping("/shipappointments/{id}")
    public Map<String, Boolean> deleteShipAppointment(@PathVariable Long id) {

        ShipAppointment shipAppointment = shipAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShipAppointment does not exist with id:" + id));

        shipAppointmentRepository.delete(shipAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }


    @GetMapping("/shipappointments/ship/{type}/{shipid}")
    public List<ShipAppointment> getAppointmentByShipId(@PathVariable String type,@PathVariable Long shipid) {
        if (type.equals("ship_owner") || type.equals("admin") || type.equals("main_admin")) {
            return shipAppointmentRepository.findByShipId(shipid);
        }
        else return null;
    }
}
