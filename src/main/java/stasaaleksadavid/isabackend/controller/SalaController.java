package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Organizator;
import stasaaleksadavid.isabackend.model.Sala;
import stasaaleksadavid.isabackend.repository.SalaRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SalaController {
    @Autowired
    private SalaRepository salaRepository;

    //get all

    @GetMapping("/sale")
    public List<Sala> getAllSale(){return salaRepository.findAll();}

    //create
    @PostMapping("/sale/{type}")
    public  Sala createSala(@PathVariable String type,@RequestBody Sala sala){
        return salaRepository.save(sala);
    }

    //get by id
    @GetMapping("/sale/sala/{id}")
    public ResponseEntity <Sala> getSalaById(@PathVariable Long id){
        Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala does not exist with id:"+ id));
        return ResponseEntity.ok(sala);
    }

    //update
    @PutMapping("/sale/{type}/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable String type,@PathVariable Long id,@RequestBody Sala salaDetails){

            Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala does not exist with id:" + id));

            sala.setNaziv(salaDetails.getNaziv());
            sala.setCena(salaDetails.getCena());
            sala.setBrojMesta(salaDetails.getBrojMesta());
            sala.setTip(salaDetails.getTip());
            sala.setVrstaDogadjaja(salaDetails.getVrstaDogadjaja());

            Sala updatedSala = salaRepository.save(sala);
            return ResponseEntity.ok(updatedSala);

    }


    //delete
    @DeleteMapping("/sale/{type}/{id}")
    public Map<String, Boolean> deleteSala(@PathVariable Long id,@PathVariable String type) {

            Sala Sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala does not exist with id:" + id));

            salaRepository.delete(Sala);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }



}
