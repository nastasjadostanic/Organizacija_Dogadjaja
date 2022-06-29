package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.AdventureQuickAppointment;
import stasaaleksadavid.isabackend.repository.AdventureQuickAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdventureQuickAppointmentController {
    @Autowired
    private AdventureQuickAppointmentRepository adventureQuickAppointmentRepository;

    //get all

    @GetMapping("/adventurequickappointments")
    public List<AdventureQuickAppointment> getAllAdventureQuickAppointments() {
        return adventureQuickAppointmentRepository.findAll();
    }

    //create
    @PostMapping("/adventurequickappointments/{type}")
    public AdventureQuickAppointment createAdventureQuickAppointment(@PathVariable String type,@RequestBody AdventureQuickAppointment adventureQuickAppointment) {
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureQuickAppointmentRepository.save(adventureQuickAppointment);
        }
        else{return null;}
    }

    //get by id
    @GetMapping("/adventurequickappointments/{id}")
    public ResponseEntity<AdventureQuickAppointment> getAdventureQuickAppointmentById(@PathVariable Long id) {
        AdventureQuickAppointment adventureQuickAppointment = adventureQuickAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureQuickAppointment does not exist with id:" + id));
        return ResponseEntity.ok(adventureQuickAppointment);
    }

    //update
    @PutMapping("/adventurequickappointments/{id}")
    public ResponseEntity<AdventureQuickAppointment> updateAdventureQuickAppointment(@PathVariable Long id, @RequestBody AdventureQuickAppointment adventureQuickAppointmentDetails) {
        AdventureQuickAppointment adventureQuickAppointment = adventureQuickAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureQuickAppointment does not exist with id:" + id));

        adventureQuickAppointment.setAdventureId(adventureQuickAppointmentDetails.getAdventureId());
        adventureQuickAppointment.setLocation(adventureQuickAppointmentDetails.getLocation());
        adventureQuickAppointment.setInstructorId(adventureQuickAppointmentDetails.getInstructorId());
        adventureQuickAppointment.setStartingDate(adventureQuickAppointmentDetails.getStartingDate());
        adventureQuickAppointment.setEndingDate(adventureQuickAppointmentDetails.getEndingDate());
        adventureQuickAppointment.setNumberOfPeople(adventureQuickAppointmentDetails.getNumberOfPeople());
        adventureQuickAppointment.setAdditionalServices(adventureQuickAppointmentDetails.getAdditionalServices());
        adventureQuickAppointment.setPrice(adventureQuickAppointmentDetails.getPrice());


        AdventureQuickAppointment updatedAdventureQuickAppointment = adventureQuickAppointmentRepository.save(adventureQuickAppointment);
        return ResponseEntity.ok(updatedAdventureQuickAppointment);
    }


    //delete
    @DeleteMapping("/adventurequickappointments/{id}")
    public Map<String, Boolean> deleteAdventureQuickAppointment(@PathVariable Long id) {

        AdventureQuickAppointment adventureQuickAppointment = adventureQuickAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureQuickAppointment does not exist with id:" + id));

        adventureQuickAppointmentRepository.delete(adventureQuickAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }


    @GetMapping("/adventurequickappointments/instructor/{instructorid}/{type}")
    public List<AdventureQuickAppointment> getAppointmentByInstructorId(@PathVariable String type,@PathVariable Long instructorid) {
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureQuickAppointmentRepository.findByInstructorId(instructorid);
        }
        else{return null;}
    }

    @GetMapping("/adventurequickappointments/adventure/{adventureid}")
    public List<AdventureQuickAppointment> getAppointmentByAdventureId(@PathVariable Long adventureid) {
        return adventureQuickAppointmentRepository.findByAdventureId(adventureid);
    }
}
