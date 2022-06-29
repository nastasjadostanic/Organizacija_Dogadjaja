package stasaaleksadavid.isabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.CottageHistoryAppointment;
import stasaaleksadavid.isabackend.repository.CottageHistoryAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CottageHistoryAppointmentController {

    @Autowired
    private CottageHistoryAppointmentRepository cottageHistoryAppointmentRepository;

    //get all

    @GetMapping("/cottagehistoryappointments")
    public List<CottageHistoryAppointment> getAllCottageHistoryAppointments() {
        return cottageHistoryAppointmentRepository.findAll();
    }

    //create
    @PostMapping("/cottagehistoryappointments")
    public CottageHistoryAppointment createCottageHistoryAppointment(@RequestBody CottageHistoryAppointment cottageHistoryAppointment) {
        return cottageHistoryAppointmentRepository.save(cottageHistoryAppointment);
    }

    //get by id
    @GetMapping("/cottagehistoryappointments/{id}")
    public ResponseEntity<CottageHistoryAppointment> getCottageHistoryAppointmentById(@PathVariable Long id) {
        CottageHistoryAppointment cottageHistoryAppointment = cottageHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageHistoryAppointment does not exist with id:" + id));
        return ResponseEntity.ok(cottageHistoryAppointment);
    }

    //update
    @PutMapping("/cottagehistoryappointments/{id}")
    public ResponseEntity<CottageHistoryAppointment> updateCottageHistoryAppointment(@PathVariable Long id, @RequestBody CottageHistoryAppointment cottageHistoryAppointmentDetails) {
        CottageHistoryAppointment cottageHistoryAppointment = cottageHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageHistoryAppointment does not exist with id:" + id));

        cottageHistoryAppointment.setCottageId(cottageHistoryAppointmentDetails.getCottageId());
        cottageHistoryAppointment.setStartingDate(cottageHistoryAppointmentDetails.getStartingDate());
        cottageHistoryAppointment.setEndingDate(cottageHistoryAppointmentDetails.getEndingDate());
        cottageHistoryAppointment.setNumberOfPeople(cottageHistoryAppointmentDetails.getNumberOfPeople());
        cottageHistoryAppointment.setAdditionalServices(cottageHistoryAppointmentDetails.getAdditionalServices());
        cottageHistoryAppointment.setPrice(cottageHistoryAppointmentDetails.getPrice());
        cottageHistoryAppointment.setClientId(cottageHistoryAppointmentDetails.getClientId());


        CottageHistoryAppointment updatedCottageHistoryAppointment = cottageHistoryAppointmentRepository.save(cottageHistoryAppointment);
        return ResponseEntity.ok(updatedCottageHistoryAppointment);
    }


    //delete
    @DeleteMapping("/cottagehistoryappointments/{id}")
    public Map<String, Boolean> deleteCottageHistoryAppointment(@PathVariable Long id) {

        CottageHistoryAppointment cottageHistoryAppointment = cottageHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageHistoryAppointment does not exist with id:" + id));

        cottageHistoryAppointmentRepository.delete(cottageHistoryAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
//get by cottage id
    @GetMapping("/cottagehistoryappointments/cottage/{type}/{cottageid}")
    public List<CottageHistoryAppointment> getHistoryAppointmentByCottageId(@PathVariable String type,@PathVariable Long cottageid) {
        if (type.equals("main_admin") || type.equals("admin") || type.equals("cottage_owner")) {
        return cottageHistoryAppointmentRepository.findByCottageId(cottageid);
            }
        else {return null;}
    }
}
