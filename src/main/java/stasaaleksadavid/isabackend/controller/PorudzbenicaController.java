package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Porudzbenica;
import stasaaleksadavid.isabackend.repository.PorudzbenicaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PorudzbenicaController {
    @Autowired
    private PorudzbenicaRepository porudzbenicaRepository;

    //get all

    @GetMapping("/porudzbenica/{type}")
    public List<Porudzbenica> getAllPorudzbenicas(@PathVariable String type){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")) {
            return porudzbenicaRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/porudzbenica/{type}")
    public  Porudzbenica createPorudzbenica(@PathVariable String type,@RequestBody Porudzbenica porudzbenica){
        if( type.equals("Gost") || type.equals("Konobar")) {
            return porudzbenicaRepository.save(porudzbenica);
        }
        else{return null;}
    }

    //get by id

    @GetMapping("/porudzbenica/id/{type}/{id}")
    public ResponseEntity<Porudzbenica> getPorudzbenicaById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")) {
            Porudzbenica porudzbenica = porudzbenicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Porudzbenica does not exist with id:" + id));
            return ResponseEntity.ok(porudzbenica);
        }
        else return null;

    }
    //update
    @PutMapping("/porudzbenica/{type}/{id}")
    public ResponseEntity<Porudzbenica> updatePorudzbenica(@PathVariable String type,@PathVariable Long id,@RequestBody Porudzbenica porudzbenicaDetails){

        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            Porudzbenica porudzbenica = porudzbenicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Porudzbenica does not exist with id:" + id));

            porudzbenica.setGostId(porudzbenicaDetails.getGostId());
            porudzbenica.setKomentar(porudzbenicaDetails.getKomentar());


            Porudzbenica updatedPorudzbenica = porudzbenicaRepository.save(porudzbenica);
            return ResponseEntity.ok(updatedPorudzbenica);
        }
        else{return null;}
    }
    //delete
    @DeleteMapping("/porudzbenica/{type}/{id}")
    public Map<String, Boolean> deletePorudzbenica(@PathVariable Long id,@PathVariable String type) {
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")) {
            Porudzbenica porudzbenica = porudzbenicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Porudzbenica does not exist with id:" + id));

            porudzbenicaRepository.delete(porudzbenica);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }

    //get by gostId
    @GetMapping("/porudzbenica/gost/{type}/{gostId}")
    public List<Porudzbenica> getAllPorudzbenicaByGostId(@PathVariable long gostId, @PathVariable String type){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            return porudzbenicaRepository.findByGostId(gostId);}
        return null;
    }


}
