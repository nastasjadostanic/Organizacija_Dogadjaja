package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.CottageSubscription;

import stasaaleksadavid.isabackend.repository.CottageSubscriptionRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CottageSubscriptionController {

    @Autowired
    private CottageSubscriptionRepository cottageSubscriptionRepository;

    //get all
    @GetMapping("/cottagesubscriptions")
    public List<CottageSubscription> getAllCottageSubscriptions(){return cottageSubscriptionRepository.findAll();}

    //create
    @PostMapping("/cottagesubscriptions")
    public CottageSubscription createCottageSubscription(@RequestBody CottageSubscription cottageSubscription){
        return cottageSubscriptionRepository.save(cottageSubscription);
    }

    //get by id
    @GetMapping("/cottagesubscriptions/{id}")
    public ResponseEntity<CottageSubscription> getCottageSubscriptionById(@PathVariable Long id){
        CottageSubscription cottageSubscription = cottageSubscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageSubscription does not exist with id:"+ id));
        return ResponseEntity.ok(cottageSubscription);
    }


    //update
    @PutMapping("/cottagesubscriptions/{id}")
    public ResponseEntity<CottageSubscription> updateCottageSubscription(@PathVariable Long id,@RequestBody CottageSubscription cottageSubscriptionDetails){
        CottageSubscription cottageSubscription = cottageSubscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageSubscription does not exist with id:"+ id));

        cottageSubscription.setCottageId(cottageSubscriptionDetails.getCottageId());
        cottageSubscription.setEmail(cottageSubscriptionDetails.getEmail());
        

        CottageSubscription updatedCottageSubscription = cottageSubscriptionRepository.save(cottageSubscription);
        return ResponseEntity.ok(updatedCottageSubscription);
    }


    //delete
    @DeleteMapping("/cottagesubscriptions/{id}")
    public Map<String, Boolean> deleteCottageSubscription(@PathVariable Long id){

        CottageSubscription cottageSubscription = cottageSubscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageSubscription does not exist with id:"+ id));

        cottageSubscriptionRepository.delete(cottageSubscription);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

// get by Email and Password
    @GetMapping("/cottagesubscriptions/cottageid/{type}/{cottageid}")
    public List<CottageSubscription> getCottageSubsByCottageId(@PathVariable String type,@PathVariable Long cottageid) {
        if (type.equals("admin") || type.equals("cottage_owner") || type.equals("main_admin")) {
            return cottageSubscriptionRepository.findByCottageId(cottageid);
        }
        else return null;
    }


    
}
