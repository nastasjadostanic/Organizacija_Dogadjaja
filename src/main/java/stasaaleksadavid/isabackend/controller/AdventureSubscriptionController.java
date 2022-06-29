package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.AdventureSubscription;
import stasaaleksadavid.isabackend.repository.AdventureSubscriptionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdventureSubscriptionController {

    @Autowired
    private AdventureSubscriptionRepository adventureSubscriptionRepository;

    //get all
    @GetMapping("/adventuresubscriptions")
    public List<AdventureSubscription> getAllAdventureSubscriptions(){return adventureSubscriptionRepository.findAll();}

    //create
    @PostMapping("/adventuresubscriptions")
    public AdventureSubscription createAdventureSubscription(@RequestBody AdventureSubscription adventureSubscription){
        return adventureSubscriptionRepository.save(adventureSubscription);
    }

    //get by id
    @GetMapping("/adventuresubscriptions/{id}")
    public ResponseEntity<AdventureSubscription> getAdventureSubscriptionById(@PathVariable Long id){
        AdventureSubscription adventureSubscription = adventureSubscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureSubscription does not exist with id:"+ id));
        return ResponseEntity.ok(adventureSubscription);
    }


    //update
    @PutMapping("/adventuresubscriptions/{id}")
    public ResponseEntity<AdventureSubscription> updateAdventureSubscription(@PathVariable Long id,@RequestBody AdventureSubscription adventureSubscriptionDetails){
        AdventureSubscription adventureSubscription = adventureSubscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureSubscription does not exist with id:"+ id));

        adventureSubscription.setAdventureId(adventureSubscriptionDetails.getAdventureId());
        adventureSubscription.setEmail(adventureSubscriptionDetails.getEmail());
        

        AdventureSubscription updatedAdventureSubscription = adventureSubscriptionRepository.save(adventureSubscription);
        return ResponseEntity.ok(updatedAdventureSubscription);
    }


    //delete
    @DeleteMapping("/adventuresubscriptions/{id}")
    public Map<String, Boolean> deleteAdventureSubscription(@PathVariable Long id){

        AdventureSubscription adventureSubscription = adventureSubscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdventureSubscription does not exist with id:"+ id));

        adventureSubscriptionRepository.delete(adventureSubscription);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

// get by Email and Password
    @GetMapping("/adventuresubscriptions/adventureid/{adventureid}")
    public List<AdventureSubscription> getAdventureSubsByAdventureId(@PathVariable Long adventureid){
    return adventureSubscriptionRepository.findByAdventureId(adventureid);
    }

    
}
