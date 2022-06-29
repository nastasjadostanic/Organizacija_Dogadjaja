package stasaaleksadavid.isabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.AdventureHistoryAppointment;
import stasaaleksadavid.isabackend.repository.AdventureHistoryAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdventureHistoryAppointmentController {

    @Autowired
    private AdventureHistoryAppointmentRepository adventureHistoryAppointmentRepository;

    //get all

    @GetMapping("/adventurehistoryappointments/type/{type}")
    public List<AdventureHistoryAppointment> getAllAdventureHistoryAppointments(@PathVariable String type) {
        if(type.equals("admin")|| type.equals("main_admin")) {
        return adventureHistoryAppointmentRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/adventurehistoryappointments")
    public AdventureHistoryAppointment createAdventureHistoryAppointment(@RequestBody AdventureHistoryAppointment adventureHistoryAppointment) {



        return adventureHistoryAppointmentRepository.save(adventureHistoryAppointment);
    }

    //get by id
    @GetMapping("/adventurehistoryappointments/{id}")
    public ResponseEntity<AdventureHistoryAppointment> getAdventureHistoryAppointmentById(@PathVariable Long id) {
        AdventureHistoryAppointment adventureHistoryAppointment = adventureHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureHistoryAppointment does not exist with id:" + id));
        return ResponseEntity.ok(adventureHistoryAppointment);
    }

    //update
    @PutMapping("/adventurehistoryappointments/{id}")
    public ResponseEntity<AdventureHistoryAppointment> updateAdventureHistoryAppointment(@PathVariable Long id, @RequestBody AdventureHistoryAppointment adventureHistoryAppointmentDetails) {
        AdventureHistoryAppointment adventureHistoryAppointment = adventureHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureHistoryAppointment does not exist with id:" + id));

        adventureHistoryAppointment.setAdventureId(adventureHistoryAppointmentDetails.getAdventureId());
        adventureHistoryAppointment.setLocation(adventureHistoryAppointmentDetails.getLocation());
        adventureHistoryAppointment.setInstructorId(adventureHistoryAppointmentDetails.getInstructorId());
        adventureHistoryAppointment.setStartingDate(adventureHistoryAppointmentDetails.getStartingDate());
        adventureHistoryAppointment.setEndingDate(adventureHistoryAppointmentDetails.getEndingDate());
        adventureHistoryAppointment.setNumberOfPeople(adventureHistoryAppointmentDetails.getNumberOfPeople());
        adventureHistoryAppointment.setAdditionalServices(adventureHistoryAppointmentDetails.getAdditionalServices());
        adventureHistoryAppointment.setPrice(adventureHistoryAppointmentDetails.getPrice());
        adventureHistoryAppointment.setClientId(adventureHistoryAppointmentDetails.getClientId());


        AdventureHistoryAppointment updatedAdventureHistoryAppointment = adventureHistoryAppointmentRepository.save(adventureHistoryAppointment);
        return ResponseEntity.ok(updatedAdventureHistoryAppointment);
    }


    //delete
    @DeleteMapping("/adventurehistoryappointments/{id}")
    public Map<String, Boolean> deleteAdventureHistoryAppointment(@PathVariable Long id) {

        AdventureHistoryAppointment adventureHistoryAppointment = adventureHistoryAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureHistoryAppointment does not exist with id:" + id));

        adventureHistoryAppointmentRepository.delete(adventureHistoryAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    @GetMapping("/adventurehistoryappointments/instructor/{instructorid}")
    public List<AdventureHistoryAppointment> getHistoryAppointmentByInstructorId(@PathVariable Long instructorid) {
        return adventureHistoryAppointmentRepository.findByInstructorId(instructorid);
    }

    @GetMapping("/adventurehistoryappointments/adventure/{type}/{adventureid}")
    public List<AdventureHistoryAppointment> getHistoryAppointmentByAdventureId(@PathVariable String type,@PathVariable Long adventureid) {
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureHistoryAppointmentRepository.findByAdventureId(adventureid);
        }
        else{return null;}
    }
}
