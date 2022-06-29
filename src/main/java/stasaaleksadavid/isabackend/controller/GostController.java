package stasaaleksadavid.isabackend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Gost;
import stasaaleksadavid.isabackend.repository.GostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class GostController {

    @Autowired
    private GostRepository GostRepository;

    //get all

    @GetMapping("/gosti")
    public List<Gost> getAllGosti(){return GostRepository.findAll();}

    //create
    @PostMapping("/gosti")
    public  Gost createGost(@RequestBody Gost gost){
        return GostRepository.save(gost);
    }

    //get by id
    @GetMapping("/gosti/{id}")
    public ResponseEntity <Gost> getGostById(@PathVariable Long id){
        Gost gost = GostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gost does not exist with id:"+ id));
        return ResponseEntity.ok(gost);
    }

    //update
    @PutMapping("/gosti/{id}")
    public ResponseEntity<Gost> updateGost(@PathVariable Long id,@RequestBody Gost gostDetails){
        Gost gost = GostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gost does not exist with id:"+ id));

        gost.setLozinka(gostDetails.getLozinka());
        gost.setIme(gostDetails.getIme());
        gost.setPrezime(gostDetails.getPrezime());
        gost.setDatumRodjenja(gostDetails.getDatumRodjenja());
        gost.setEmail(gostDetails.getEmail());
        gost.setTelefon(gostDetails.getTelefon());
        gost.setAdresa(gostDetails.getAdresa());


        Gost updatedGost = GostRepository.save(gost);
        return ResponseEntity.ok(updatedGost);
    }


    //delete
    @DeleteMapping("/Gosti/{id}")
    public Map<String, Boolean> deleteGost(@PathVariable Long id){

        Gost Gost = GostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gost does not exist with id:"+ id));

        GostRepository.delete(Gost);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
}

