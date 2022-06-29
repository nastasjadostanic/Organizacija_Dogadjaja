package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Hrana;
import stasaaleksadavid.isabackend.model.Stavka;
import stasaaleksadavid.isabackend.repository.StavkaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StavkaController {
    @Autowired
    private StavkaRepository stavkaRepository;

    //get all

    @GetMapping("/stavka/{type}")
    public List<Stavka> getAllStavkas(@PathVariable String type){
        if(type.equals("admin") || type.equals("main_admin")) {
            return stavkaRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/stavka/{type}")
    public  Stavka createStavka(@PathVariable String type,@RequestBody Stavka stavka){
        if(type.equals("admin") || type.equals("main_admin")) {
            return stavkaRepository.save(stavka);
        }
        else{return null;}
    }

    //get by id

    @GetMapping("/stavka/id/{type}/{id}")
    public ResponseEntity<Stavka> getStavkaById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")) {
            Stavka stavka = stavkaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stavka does not exist with id:" + id));
            return ResponseEntity.ok(stavka);
        }
        else return null;

    }
    //update
    @PutMapping("/stavka/{type}/{id}")
    public ResponseEntity<Stavka> updateStavka(@PathVariable String type,@PathVariable Long id,@RequestBody Stavka stavkaDetails){

        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")){
            Stavka stavka = stavkaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stavka does not exist with id:" + id));

            stavka.setKolicina(stavkaDetails.getKolicina());
            stavka.setPorudzbenicaId(stavkaDetails.getPorudzbenicaId());
            stavka.setHranaId(stavkaDetails.getHranaId());

            Stavka updatedStavka = stavkaRepository.save(stavka);
            return ResponseEntity.ok(updatedStavka);
        }
        else{return null;}
    }
    //delete
    @DeleteMapping("/stavka/{type}/{id}")
    public Map<String, Boolean> deleteStavka(@PathVariable Long id,@PathVariable String type) {
        if ( type.equals("admin") ||  type.equals("main_admin")) {
            Stavka stavka = stavkaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stavka does not exist with id:" + id));

            stavkaRepository.delete(stavka);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }

    //get by hranaId
    @GetMapping("/stavka/hrana/{type}/{hranaId}")
    public List<Stavka> getAllStavkaByHranaId(@PathVariable("hranaId") long hranaId, @PathVariable("type") String type){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            return stavkaRepository.findByHranaId(hranaId);}

        return null;
    }
    //get by PorudzbenicaId
    @GetMapping("/stavka/porudzbenica/{type}/{hranaId}")
    public List<Stavka> getAllStavkaByPorudzbenicaId(@PathVariable("porudzbenicaId") long porudzbenicaId, @PathVariable("type") String type){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            return stavkaRepository.findByPorudzbenicaId(porudzbenicaId);}

        return null;
    }


}
