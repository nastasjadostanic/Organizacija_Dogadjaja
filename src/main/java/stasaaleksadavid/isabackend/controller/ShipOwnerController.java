package stasaaleksadavid.isabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.CottageOwner;
import stasaaleksadavid.isabackend.model.ShipOwner;
import stasaaleksadavid.isabackend.repository.ShipOwnerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ShipOwnerController {

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    //get all

    @GetMapping("/shipowners")
    public List<ShipOwner> getAllShipOwners() {
        return shipOwnerRepository.findAll();
    }

    //create
    @PostMapping("/shipowners")
    public ShipOwner createShipOwner(@RequestBody ShipOwner shipOwner) {
        return shipOwnerRepository.save(shipOwner);
    }

    //get by id
    @GetMapping("/shipowners/{id}")
    public ResponseEntity<ShipOwner> getCottageOwnerById(@PathVariable Long id) {
        ShipOwner shipOwner = shipOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship owner does not exist with id:" + id));
        return ResponseEntity.ok(shipOwner);
    }

    //update
    @PutMapping("/shipowners/{id}")
    public ResponseEntity<ShipOwner> updateShipOwner(@PathVariable Long id, @RequestBody ShipOwner shipOwnerDetails) {
        ShipOwner shipOwner = shipOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship owner does not exist with id:" + id));

        shipOwner.setPassword(shipOwnerDetails.getPassword());
        shipOwner.setFirstName(shipOwnerDetails.getFirstName());
        shipOwner.setLastName(shipOwnerDetails.getLastName());
        shipOwner.setDateOfBirth(shipOwnerDetails.getDateOfBirth());
        shipOwner.setEmail(shipOwnerDetails.getEmail());
        shipOwner.setPhoneNumber(shipOwnerDetails.getPhoneNumber());
        shipOwner.setAddress(shipOwnerDetails.getAddress());
        shipOwner.setCity(shipOwnerDetails.getCity());
        shipOwner.setCountry(shipOwnerDetails.getCountry());

        ShipOwner updatedShipOwner = shipOwnerRepository.save(shipOwner);
        return ResponseEntity.ok(updatedShipOwner);
    }


    //delete
    @DeleteMapping("/shipowners/{id}")
    public Map<String, Boolean> deleteShipOwner(@PathVariable Long id) {

        ShipOwner shipOwner = shipOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship owner does not exist with id:" + id));

        shipOwnerRepository.delete(shipOwner);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    @GetMapping("/shipowners/login/{email}/{password}")
    public ResponseEntity<ShipOwner> getShipOwnerByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        ShipOwner shipOwner = shipOwnerRepository.findByEmailAndPassword(email, password);
        return ResponseEntity.ok(shipOwner);
    }
}