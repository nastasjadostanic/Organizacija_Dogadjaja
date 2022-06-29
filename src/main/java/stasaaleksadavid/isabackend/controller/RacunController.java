package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Racun;
import stasaaleksadavid.isabackend.repository.RacunRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class RacunController {
    @Autowired
    private RacunRepository racunRepository;

    //get all

    @GetMapping("/racun/{type}")
    public List<Racun> getAllRacuns(@PathVariable String type){
        if(type.equals("admin") || type.equals("main_admin")) {
            return racunRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/racun/{type}")
    public  Racun createRacun(@PathVariable String type,@RequestBody Racun racun){
        if(type.equals("admin") || type.equals("main_admin")) {
            return racunRepository.save(racun);
        }
        else{return null;}
    }

    //get by id

    @GetMapping("/racun/id/{type}/{id}")
    public ResponseEntity<Racun> getRacunById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")) {
            Racun racun = racunRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Racun does not exist with id:" + id));
            return ResponseEntity.ok(racun);
        }
        else return null;

    }
    //update
    @PutMapping("/racun/{type}/{id}")
    public ResponseEntity<Racun> updateRacun(@PathVariable String type,@PathVariable Long id,@RequestBody Racun racunDetails){

        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")){
            Racun racun = racunRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Racun does not exist with id:" + id));

            racun.setPorudzbenicaId(racunDetails.getPorudzbenicaId());
            racun.setDatum(racunDetails.getDatum());

            Racun updatedRacun = racunRepository.save(racun);
            return ResponseEntity.ok(updatedRacun);
        }
        else{return null;}
    }
    //delete
    @DeleteMapping("/racun/{type}/{id}")
    public Map<String, Boolean> deleteRacun(@PathVariable Long id,@PathVariable String type) {
        if ( type.equals("admin") ||  type.equals("main_admin")) {
            Racun racun = racunRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Racun does not exist with id:" + id));

            racunRepository.delete(racun);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }

    // get by porudzbenicaId
    @GetMapping("/racun/porudzbenica/{type}/{porudzbenicaId}")
    public Racun getReceptByHranaId(@PathVariable("porudzbenicaId") long porudzbenicaId, @PathVariable("type") String type){
        if(type.equals("Kuvar") ){
            Racun loggedRacun = racunRepository.findByPorudzbenicaId(porudzbenicaId);
            return loggedRacun;}

        return null;
    }


}
