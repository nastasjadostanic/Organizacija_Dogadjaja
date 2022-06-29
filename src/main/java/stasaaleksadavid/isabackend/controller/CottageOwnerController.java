package stasaaleksadavid.isabackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.CottageOwner;
import stasaaleksadavid.isabackend.repository.CottageOwnerRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CottageOwnerController {

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    //get all

    @GetMapping("/cottageowners")
    public List<CottageOwner> getAllCottageOwners(){return cottageOwnerRepository.findAll();}


    //create
    @PostMapping("/cottageowners")
    public CottageOwner createCottageOwner(@RequestBody CottageOwner cottageOwner){
        return cottageOwnerRepository.save(cottageOwner);
    }

    //get by id
    @GetMapping("/cottageowners/{id}")
    public ResponseEntity<CottageOwner> getCottageOwnerById(@PathVariable Long id){
        CottageOwner cottageOwner = cottageOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageOwner does not exist with id:"+ id));
        return ResponseEntity.ok(cottageOwner);
    }

    //update
    @PutMapping("/cottageowners/{id}")
    public ResponseEntity<CottageOwner> updateCottageOwner(@PathVariable Long id,@RequestBody CottageOwner cottageOwnerDetails){
        CottageOwner cottageOwner = cottageOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageOwner does not exist with id:"+ id));

        cottageOwner.setPassword(cottageOwnerDetails.getPassword());
        cottageOwner.setFirstName(cottageOwnerDetails.getFirstName());
        cottageOwner.setLastName(cottageOwnerDetails.getLastName());
        cottageOwner.setDateOfBirth(cottageOwnerDetails.getDateOfBirth());
        cottageOwner.setEmail(cottageOwnerDetails.getEmail());
        cottageOwner.setPhoneNumber(cottageOwnerDetails.getPhoneNumber());
        cottageOwner.setAddress(cottageOwnerDetails.getAddress());
        cottageOwner.setCity(cottageOwnerDetails.getCity());
        cottageOwner.setCountry(cottageOwnerDetails.getCountry());

        CottageOwner updatedCottageOwner = cottageOwnerRepository.save(cottageOwner);
        return ResponseEntity.ok(updatedCottageOwner);
    }


    //delete
    @DeleteMapping("/cottageowners/{id}")
    public Map<String, Boolean> deleteCottageOwner(@PathVariable Long id){

        CottageOwner cottageOwner = cottageOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageOwner does not exist with id:"+ id));

        cottageOwnerRepository.delete(cottageOwner);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    // find by email and password

    @GetMapping("/cottageowners/login/{email}/{password}")
    public ResponseEntity<CottageOwner> getCottageOwnerByEmailAndPassword(@PathVariable String email,@PathVariable String password){
        CottageOwner cottageOwner = cottageOwnerRepository.findByEmailAndPassword(email,password);
        return ResponseEntity.ok(cottageOwner);
    }





}
