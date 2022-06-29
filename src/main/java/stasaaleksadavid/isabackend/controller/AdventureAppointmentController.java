package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.AdventureAppointment;
import stasaaleksadavid.isabackend.model.CottageAppointment;
import stasaaleksadavid.isabackend.model.CottageFreeAppointment;
import stasaaleksadavid.isabackend.repository.AdventureAppointmentRepository;
import stasaaleksadavid.isabackend.repository.AdventureFreeAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import stasaaleksadavid.isabackend.model.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdventureAppointmentController {

    @Autowired
    private AdventureAppointmentRepository adventureAppointmentRepository;

    @Autowired
    private AdventureFreeAppointmentRepository adventureFreeAppointmentRepository;
    //get all

    @GetMapping("/adventureappointments/{type}")
  public List<AdventureAppointment> getAllAdventureAppointments(@PathVariable String type) {
        if(type.equals("admin")|| type.equals("main_admin")) {
            return adventureAppointmentRepository.findAll();
        }
        else{return null;}

    }

    //create
    @PostMapping("/adventureappointments/{type}")
    public AdventureAppointment createAdventureAppointment(@PathVariable String type,@RequestBody AdventureAppointment adventureAppointment) {
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        List<AdventureFreeAppointment> adventureFreeAppointments = adventureFreeAppointmentRepository.findByAdventureId(adventureAppointment.getAdventureId());

        for (AdventureFreeAppointment a : adventureFreeAppointments) {
            if (adventureAppointment.getStartingDate().isAfter(a.getStartingDate()) && adventureAppointment.getEndingDate().isBefore(a.getEndingDate())) {


                AdventureFreeAppointment freeAppointment_1 = new AdventureFreeAppointment(adventureAppointment.getInstructorId(), a.getAdventureId(), a.getLocation(), a.getStartingDate(), adventureAppointment.getStartingDate(), a.getNumberOfPeople(), a.getAdditionalServices(), a.getPrice());
                AdventureFreeAppointment freeAppointment_2 = new AdventureFreeAppointment(adventureAppointment.getInstructorId(), a.getAdventureId(), a.getLocation(), adventureAppointment.getEndingDate(), a.getEndingDate(), a.getNumberOfPeople(), a.getAdditionalServices(), a.getPrice());
                AdventureAppointment newAdventureAppointment = new AdventureAppointment(adventureAppointment.getAdventureId(), adventureAppointment.getInstructorId(), adventureAppointment.getClientId(), adventureAppointment.getLocation(), adventureAppointment.getStartingDate(), adventureAppointment.getEndingDate(), adventureAppointment.getNumberOfPeople(), adventureAppointment.getAdditionalServices(), adventureAppointment.getPrice());

                adventureFreeAppointmentRepository.deleteById(a.getId());
                adventureFreeAppointmentRepository.save(freeAppointment_1);
                adventureFreeAppointmentRepository.save(freeAppointment_2);

                return adventureAppointmentRepository.save(newAdventureAppointment);
            } else if (adventureAppointment.getStartingDate().isAfter(a.getStartingDate()) && adventureAppointment.getEndingDate().isAfter(a.getEndingDate())) {
                AdventureFreeAppointment freeAppointment_1 = new AdventureFreeAppointment(a.getInstructorId(), a.getAdventureId(), a.getLocation(), a.getStartingDate(), adventureAppointment.getStartingDate(), a.getNumberOfPeople(), a.getAdditionalServices(), a.getPrice());
                AdventureAppointment newAdventureAppointment = new AdventureAppointment(adventureAppointment.getAdventureId(), adventureAppointment.getInstructorId(), adventureAppointment.getClientId(), adventureAppointment.getLocation(), adventureAppointment.getStartingDate(), a.getEndingDate(), adventureAppointment.getNumberOfPeople(), a.getAdditionalServices(), a.getPrice());
                adventureFreeAppointmentRepository.deleteById(a.getId());
                adventureFreeAppointmentRepository.save(freeAppointment_1);

                return adventureAppointmentRepository.save(newAdventureAppointment);
            } else if (adventureAppointment.getStartingDate().isBefore(a.getStartingDate()) && adventureAppointment.getEndingDate().isBefore(a.getEndingDate())) {
                AdventureFreeAppointment freeAppointment_1 = new AdventureFreeAppointment(a.getInstructorId(), a.getAdventureId(), a.getLocation(), adventureAppointment.getEndingDate(), a.getEndingDate(), a.getNumberOfPeople(), a.getAdditionalServices(), a.getPrice());
                AdventureAppointment newAdventureAppointment = new AdventureAppointment(adventureAppointment.getAdventureId(), adventureAppointment.getInstructorId(), adventureAppointment.getClientId(), adventureAppointment.getLocation(), a.getStartingDate(), adventureAppointment.getEndingDate(), adventureAppointment.getNumberOfPeople(), adventureAppointment.getAdditionalServices(), adventureAppointment.getPrice());

                adventureFreeAppointmentRepository.deleteById(a.getId());
                adventureFreeAppointmentRepository.save(freeAppointment_1);

                return adventureAppointmentRepository.save(newAdventureAppointment);
            } else if (adventureAppointment.getStartingDate().isBefore(a.getStartingDate()) && adventureAppointment.getEndingDate().isAfter(a.getEndingDate())) {

                return null;
            }

        }return adventureAppointmentRepository.save(adventureAppointment);
        }
        else{return null;}

    }
    //get by id
    @GetMapping("/adventureappointments/{id}")
    public ResponseEntity<AdventureAppointment> getAdventureAppointmentById(@PathVariable Long id) {
        AdventureAppointment adventureAppointment = adventureAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureAppointment does not exist with id:" + id));
        return ResponseEntity.ok(adventureAppointment);
    }

    //update
    @PutMapping("/adventureappointments/{id}")
    public ResponseEntity<AdventureAppointment> updateAdventureAppointment(@PathVariable Long id, @RequestBody AdventureAppointment adventureAppointmentDetails) {
        AdventureAppointment adventureAppointment = adventureAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureAppointment does not exist with id:" + id));

        adventureAppointment.setClientId(adventureAppointmentDetails.getClientId());
        adventureAppointment.setAdventureId(adventureAppointmentDetails.getAdventureId());
        adventureAppointment.setStartingDate(adventureAppointmentDetails.getStartingDate());
        adventureAppointment.setEndingDate(adventureAppointmentDetails.getEndingDate());
        adventureAppointment.setNumberOfPeople(adventureAppointmentDetails.getNumberOfPeople());
        adventureAppointment.setAdditionalServices(adventureAppointmentDetails.getAdditionalServices());
        adventureAppointment.setPrice(adventureAppointmentDetails.getPrice());
        adventureAppointment.setLocation(adventureAppointmentDetails.getLocation());
        adventureAppointment.setInstructorId(adventureAppointmentDetails.getInstructorId());


        AdventureAppointment updatedAdventureAppointment = adventureAppointmentRepository.save(adventureAppointment);
        return ResponseEntity.ok(updatedAdventureAppointment);
    }


    //delete
    @DeleteMapping("/adventureappointments/{id}")
    public Map<String, Boolean> deleteAdventureAppointment(@PathVariable Long id) {

        AdventureAppointment adventureAppointment = adventureAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureAppointment does not exist with id:" + id));

        adventureAppointmentRepository.delete(adventureAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }


    @GetMapping("/adventureappointments/instructor/{type}/{instructorid}")
    public List<AdventureAppointment> getAppointmentByInstructorId(@PathVariable String type,@PathVariable Long instructorid) {
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureAppointmentRepository.findByInstructorId(instructorid);
        }
        else{return null;}
    }

    @GetMapping("/adventureappointments/adventure/{type}/{adventureid}")
    public List<AdventureAppointment> getAppointmentByAdventureId(@PathVariable String type,@PathVariable Long adventureid) {
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureAppointmentRepository.findByAdventureId(adventureid);
        }
        else{return null;}
    }
}