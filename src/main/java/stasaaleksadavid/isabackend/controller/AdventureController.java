package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Admin;
import stasaaleksadavid.isabackend.model.Adventure;
import stasaaleksadavid.isabackend.model.User;
import stasaaleksadavid.isabackend.repository.AdventureRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdventureController {
    @Autowired
    private AdventureRepository adventureRepository;
    //get all

    @GetMapping("/adventures/{type}")
    public List<Adventure> getAllAdventures(@PathVariable String type){
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/adventures/{type}")
    public Adventure createAdventure(@PathVariable String type,@RequestBody Adventure adventure){
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureRepository.save(adventure);
        }
        else{return null;}
    }

    //get by id
    @GetMapping("/adventures/{type}/{id}")
    public ResponseEntity<Adventure> getAdventureById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        Adventure adventure = adventureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adventure does not exist with id:"+ id));
        return ResponseEntity.ok(adventure);
        }
        else{return null;}
    }

    //update
    @PutMapping("/adventures/{type}/{id}")
    public ResponseEntity<Adventure> updateAdventure(@PathVariable String type,@PathVariable Long id,@RequestBody Adventure adventureDetails){
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        Adventure adventure = adventureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adventure does not exist with id:"+ id));

        adventure.setAddress(adventureDetails.getAddress());
        adventure.setDescription(adventureDetails.getDescription());
        adventure.setMaxPeople(adventureDetails.getMaxPeople());
        adventure.setName(adventureDetails.getName());
        adventure.setRulesOfConduct(adventureDetails.getRulesOfConduct());
        adventure.setTermsOfReservation(adventureDetails.getTermsOfReservation());

        adventure.setFishingEquipment(adventureDetails.getFishingEquipment());
        adventure.setAdditionalServices(adventureDetails.getAdditionalServices());
        adventure.setPrices(adventureDetails.getPrices());

        Adventure updatedAdventure = adventureRepository.save(adventure);
        return ResponseEntity.ok(updatedAdventure);
        }
        else{return null;}
    }


    //delete
    @DeleteMapping("/adventures/{type}/{id}")
    public Map<String, Boolean> deleteAdventure(@PathVariable String type,@PathVariable Long id){
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        Adventure adventure = adventureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adventure does not exist with id:"+ id));

        adventureRepository.delete(adventure);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }

    //get by instructorId
    @GetMapping("/adventures/instructorid/{type}/{instructorId}")
    public List<Adventure> getAdventuresByInstructorId(@PathVariable String type,@PathVariable Long instructorId){
        if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
        return adventureRepository.findByInstructorId(instructorId);
        }
        else{return null;}
    }

    //get by name
    @GetMapping("/adventures/name/{name}/{type}")
    public List<Adventure> getAdventuresByName(@PathVariable String type,@PathVariable String name){
            if(type.equals("fishing_instructor") || type.equals("admin") || type.equals("main_admin")) {
            return adventureRepository.findByName(name);
            }
            else{return null;}
        }

}
