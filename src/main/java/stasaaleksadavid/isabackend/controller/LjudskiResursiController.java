package stasaaleksadavid.isabackend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.LjudskiResursi;
import stasaaleksadavid.isabackend.model.NutritivneVrednosti;
import stasaaleksadavid.isabackend.model.User;
import stasaaleksadavid.isabackend.repository.LjudskiResursiRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class LjudskiResursiController {

    @Autowired
    private LjudskiResursiRepository ljudskiResursiRepository;

    //get all

    @GetMapping("/ljudskiResursi")
    public List<LjudskiResursi> getAllLjudskiResursi(){return ljudskiResursiRepository.findAll();}

    //create
    @PostMapping("/ljudskiResursi/{type}")
    public  LjudskiResursi createLjudskiResursi(@PathVariable String type,@RequestBody LjudskiResursi ljudskiResursi){
        return ljudskiResursiRepository.save(ljudskiResursi);
    }

    //get by id
    @GetMapping("/ljudskiResursi/id/{type}/{id}")
    public ResponseEntity <LjudskiResursi> getLjudskiResursiById(@PathVariable Long id){
        LjudskiResursi ljudskiResursi = ljudskiResursiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ljudski resursi does not exist with id:"+ id));
        return ResponseEntity.ok(ljudskiResursi);
    }

    //update
    @PutMapping("/ljudskiResursi/{type}/{id}")
    public ResponseEntity<LjudskiResursi> updateLjudskiResursi(@PathVariable String type,@PathVariable Long id,@RequestBody LjudskiResursi ljudskiResursiDetails){

        LjudskiResursi ljudskiResursi = ljudskiResursiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ljudski resursi does not exist with id:" + id));

        ljudskiResursi.setNaziv(ljudskiResursiDetails.getNaziv());
        ljudskiResursi.setCena(ljudskiResursiDetails.getCena());
        ljudskiResursi.setVrsta(ljudskiResursiDetails.getVrsta());
        ljudskiResursi.setBrojLjudi(ljudskiResursiDetails.getBrojLjudi());
        ljudskiResursi.setOblastDelovanja(ljudskiResursiDetails.getOblastDelovanja());
        ljudskiResursi.setBrojTelefona(ljudskiResursiDetails.getBrojTelefona());
        ljudskiResursi.setDogadjajID(ljudskiResursiDetails.getDogadjajID());

        LjudskiResursi updatedLjudskiResursi = ljudskiResursiRepository.save(ljudskiResursi);
        return ResponseEntity.ok(updatedLjudskiResursi);

    }


    //delete
    @DeleteMapping("/ljudskiResursi/{type}/{id}")
    public Map<String, Boolean> deleteLjudskiResursi(@PathVariable Long id,@PathVariable String type) {

            LjudskiResursi ljudskiResursi = ljudskiResursiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ljudski resursi does not exist with id:" + id));

            ljudskiResursiRepository.delete(ljudskiResursi);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }


    //get by dogadjajID
    @GetMapping("/ljudskiResursi/dogadjaj/{type}/{dogadjajID}")
    public List<LjudskiResursi> getLjudskiResursiByDogadjajId(@PathVariable("type") String type, @PathVariable("dogadjajID") long dogadjajID){
        if(type.equals("organizator")){
        return ljudskiResursiRepository.findByDogadjajID(dogadjajID);}
        return null;
    }
}
