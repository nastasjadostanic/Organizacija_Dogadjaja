package stasaaleksadavid.isabackend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Dogadjaj;
import stasaaleksadavid.isabackend.model.User;
import stasaaleksadavid.isabackend.repository.DogadjajRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DogadjajController {

    @Autowired
    private DogadjajRepository dogadjajRepository;

    //get all

    @GetMapping("/dogadjaji")
    public List<Dogadjaj> getAllDogadjaji(){return dogadjajRepository.findAll();}

    //create
    @PostMapping("/dogadjaji")
    public  Dogadjaj createDogadjaj(@RequestBody Dogadjaj dogadjaj){
        return dogadjajRepository.save(dogadjaj);
    }

    //get by id
    @GetMapping("/dogadjaji/{id}")
    public ResponseEntity <Dogadjaj> getDogadjajById(@PathVariable Long id){
        Dogadjaj dogadjaj = dogadjajRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dogadjaj does not exist with id:"+ id));
        return ResponseEntity.ok(dogadjaj);
    }

    //update
    @PutMapping("/dogadjaji/{type}/{id}")
    public ResponseEntity<Dogadjaj> updateDogadjaj(@PathVariable String type,@PathVariable Long id,@RequestBody Dogadjaj dogadjajDetails){
        Dogadjaj dogadjaj = dogadjajRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dogadjaj does not exist with id:"+ id));

        dogadjaj.setUkupnaCena(dogadjajDetails.getUkupnaCena());
        dogadjaj.setDatumNaplate(dogadjajDetails.getDatumNaplate());
        dogadjaj.setDatumOdrzavanja(dogadjajDetails.getDatumOdrzavanja());
        dogadjaj.setVremeOdrzavanja(dogadjajDetails.getVremeOdrzavanja());
        dogadjaj.setTrajanje(dogadjajDetails.getTrajanje());
        dogadjaj.setTip(dogadjajDetails.getTip());
        dogadjaj.setSalaID(dogadjajDetails.getSalaID());
        dogadjaj.setModifikacijaSale(dogadjajDetails.getModifikacijaSale());
        dogadjaj.setLjudskiResursId(dogadjajDetails.getLjudskiResursId());
        dogadjaj.setOstaliResursId(dogadjajDetails.getOstaliResursId());
        dogadjaj.setGostId(dogadjajDetails.getGostId());

        Dogadjaj updatedDogadjaj = dogadjajRepository.save(dogadjaj);
        return ResponseEntity.ok(updatedDogadjaj);
    }


    //delete
    @DeleteMapping("/dogadjaji/{id}")
    public Map<String, Boolean> deleteDogadjaj(@PathVariable Long id){

        Dogadjaj dogadjaj = dogadjajRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dogadjaj does not exist with id:"+ id));

        dogadjajRepository.delete(dogadjaj);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    //get all by gostId
    @GetMapping("/dogadjaji/gostId/{type}/{id}")
    public List<Dogadjaj> getAllDogadjajiByGostId(@PathVariable String type, @PathVariable Long id ){return dogadjajRepository.findByGostId(id);}

}

