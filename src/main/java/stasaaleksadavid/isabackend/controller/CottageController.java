package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Cottage;
import stasaaleksadavid.isabackend.repository.CottageRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CottageController {

    @Autowired
    private CottageRepository cottageRepository;

    //get all
    @GetMapping("/cottages/{type}")
    public List<Cottage> getAllCottages(@PathVariable String type){
        if(type.equals("admin") || type.equals("main_admin")){
        return cottageRepository.findAll();
    }
    else{return null;}
    }


    //create
    @PostMapping("/cottages/{type}")
    public Cottage createCottage(@PathVariable String type, @RequestBody Cottage cottage){
        if(type.equals("admin") || type.equals("main_admin")||type.equals("cottage_owner")) {
            return cottageRepository.save(cottage);
        }
        else return null;
    }



    //get by id
    @GetMapping("/cottages/{type}/{id}")
    public ResponseEntity<Cottage> getCottageById(@PathVariable String type,@PathVariable Long id){

        if (type.equals("main_admin") || type.equals("admin") || type.equals("cottage_owner")) {
            Cottage cottage = cottageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cottage does not exist with id:" + id));
            return ResponseEntity.ok(cottage);
        }
        else {return null;}

    }


    //update
    @PutMapping("/cottages/{type}/{id}")
    public ResponseEntity<Cottage> updateCottage(@PathVariable String type,@PathVariable Long id,@RequestBody Cottage cottageDetails){

        if (type.equals("main_admin") || type.equals("admin") || type.equals("cottage_owner")) {
            Cottage cottage = cottageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cottage does not exist with id:" + id));

            cottage.setName(cottageDetails.getName());
            cottage.setAddress(cottageDetails.getAddress());
            cottage.setDescription(cottageDetails.getAddress());
            cottage.setRating(cottageDetails.getRating());
            cottage.setNumberOfRooms(cottageDetails.getNumberOfRooms());
            cottage.setOwnerId(cottageDetails.getOwnerId());
            cottage.setRules(cottageDetails.getRules());

            Cottage updatedCottage = cottageRepository.save(cottage);
            return ResponseEntity.ok(updatedCottage);
        }
        else {return null;}
    }


    //delete
    @DeleteMapping("/cottages/{type}/{id}")
    public Map<String, Boolean> deleteCottage(@PathVariable String type,@PathVariable Long id){

        if (type.equals("main_admin") || type.equals("admin") || type.equals("cottage_owner")) {

            Cottage cottage = cottageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cottage does not exist with id:" + id));

            cottageRepository.delete(cottage);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);

        }
        else{return null;}
    }

// get by ownerId
    @GetMapping("/cottages/owner/{type}/{ownerid}")
    public List<Cottage> getCottageByEmailAndPassword(@PathVariable String type,@PathVariable Long ownerid) {
        if (type.equals("main_admin") || type.equals("admin") || type.equals("cottage_owner")){
            return cottageRepository.findByOwnerId(ownerid);
    }
    else{return null;}
    }

    
}
