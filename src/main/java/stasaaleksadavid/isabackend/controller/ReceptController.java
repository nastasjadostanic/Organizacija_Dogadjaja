package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Admin;
import stasaaleksadavid.isabackend.model.Recept;
import stasaaleksadavid.isabackend.repository.ReceptRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ReceptController {
    @Autowired
    private ReceptRepository receptRepository;

    //get all

    @GetMapping("/recept/{type}")
    public List<Recept> getAllRecepts(@PathVariable String type){
        if(type.equals("Kuvar") ) {
            return receptRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/recept/{type}")
    public  Recept createRecept(@PathVariable String type,@RequestBody Recept recept){
        if(type.equals("Kuvar") ) {
            return receptRepository.save(recept);
        }
        else{return null;}
    }

    //get by id

    @GetMapping("/recept/id/{type}/{id}")
    public ResponseEntity<Recept> getReceptById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("Kuvar") ) {
            Recept recept = receptRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recept does not exist with id:" + id));
            return ResponseEntity.ok(recept);
        }
        else return null;

    }
    //update
    @PutMapping("/recept/{type}/{id}")
    public ResponseEntity<Recept> updateRecept(@PathVariable String type,@PathVariable Long id,@RequestBody Recept receptDetails){

        if(type.equals("Kuvar") ){
            Recept recept = receptRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recept does not exist with id:" + id));

            recept.setRecept(receptDetails.getRecept());
            recept.setHranaId(receptDetails.getHranaId());


            Recept updatedRecept = receptRepository.save(recept);
            return ResponseEntity.ok(updatedRecept);
        }
        else{return null;}
    }
    //delete
    @DeleteMapping("/recept/{type}/{id}")
    public Map<String, Boolean> deleteRecept(@PathVariable Long id,@PathVariable String type) {
        if(type.equals("Kuvar") ) {
            Recept recept = receptRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recept does not exist with id:" + id));

            receptRepository.delete(recept);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }
 // get by hranaId
    @GetMapping("/recept/hrana/{type}/{hranaId}")
    public Recept getReceptByHranaId(@PathVariable("hranaId") long hranaId, @PathVariable("type") String type){
        if(type.equals("Kuvar") ){
        Recept loggedRecept = receptRepository.findByHranaId(hranaId);
        return loggedRecept;}

        return null;
    }






}
