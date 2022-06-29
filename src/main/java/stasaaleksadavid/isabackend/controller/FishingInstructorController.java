package stasaaleksadavid.isabackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.FishingInstructor;
import stasaaleksadavid.isabackend.repository.FishingInstructorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FishingInstructorController {

    @Autowired
    private FishingInstructorRepository fishingInstructorRepository;

    //get all

    @GetMapping("/fishinginstructors")
    public List<FishingInstructor> getAllFishingInstructors(){return fishingInstructorRepository.findAll();}

    //create
    @PostMapping("/fishinginstructors")
    public  FishingInstructor createFishingInstructor(@RequestBody FishingInstructor fishinginstructor){
        return fishingInstructorRepository.save(fishinginstructor);
    }

    //get by id
    @GetMapping("/fishinginstructors/{id}")
    public ResponseEntity <FishingInstructor> getFishingInstructorById(@PathVariable Long id){
        FishingInstructor  fishinginstructor = fishingInstructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fishing instructor does not exist with id:"+ id));
        return ResponseEntity.ok(fishinginstructor);
    }

    //update
    @PutMapping("/fishinginstructors/{id}")
    public ResponseEntity<FishingInstructor> updateFishingInstructor(@PathVariable Long id,@RequestBody FishingInstructor  fishinginstructorDetails){
        FishingInstructor  fishinginstructor = fishingInstructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fishing instructor does not exist with id:"+ id));

        fishinginstructor.setPassword(fishinginstructorDetails.getPassword());
        fishinginstructor.setFirstName(fishinginstructorDetails.getFirstName());
        fishinginstructor.setLastName(fishinginstructorDetails.getLastName());
        fishinginstructor.setDateOfBirth(fishinginstructorDetails.getDateOfBirth());
        fishinginstructor.setEmail(fishinginstructorDetails.getEmail());
        fishinginstructor.setPhoneNumber(fishinginstructorDetails.getPhoneNumber());
        fishinginstructor.setAddress(fishinginstructorDetails.getAddress());
        fishinginstructor.setCity(fishinginstructorDetails.getCity());
        fishinginstructor.setCountry(fishinginstructorDetails.getCountry());

        FishingInstructor updatedfishinginstructor = fishingInstructorRepository.save(fishinginstructor);
        return ResponseEntity.ok(updatedfishinginstructor);
    }


    //delete
    @DeleteMapping("/fishinginstructors/{id}")
    public Map<String, Boolean> deleteFishingInstructor(@PathVariable Long id){

        FishingInstructor  fishinginstructor = fishingInstructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fishing instructor does not exist with id:"+ id));

        fishingInstructorRepository.delete(fishinginstructor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
}
