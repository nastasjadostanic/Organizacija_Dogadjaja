package stasaaleksadavid.isabackend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.LjudskiResursi;
import stasaaleksadavid.isabackend.model.OstaliResursi;
import stasaaleksadavid.isabackend.repository.OstaliResursiRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class OstaliResursiController {

    @Autowired
    private OstaliResursiRepository ostaliResursiRepository;

    //get all

    @GetMapping("/ostaliResursi")
    public List<OstaliResursi> getAllOstaliResursi(){return ostaliResursiRepository.findAll();}

    //create
    @PostMapping("/ostaliResursi/{type}")
    public  OstaliResursi createOstaliResursi(@PathVariable String type,@RequestBody OstaliResursi ostaliResursi){
        return ostaliResursiRepository.save(ostaliResursi);
    }

    //get by id
    @GetMapping("/ostaliResursi/id/{type}/{id}")
    public ResponseEntity <OstaliResursi> getOstaliResursiById(@PathVariable Long id){
        OstaliResursi ostaliResursi =ostaliResursiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ostali resursi does not exist with id:"+ id));
        return ResponseEntity.ok(ostaliResursi);
    }

    //update
    @PutMapping("/ostaliResursi/{type}/{id}")
    public ResponseEntity<OstaliResursi> updateOstaliResursi(@PathVariable String type,@PathVariable Long id,@RequestBody OstaliResursi ostaliResursiDetails){

        OstaliResursi ostaliResursi = ostaliResursiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ostali resursi does not exist with id:" + id));

        ostaliResursi.setNaziv(ostaliResursiDetails.getNaziv());
        ostaliResursi.setCena(ostaliResursiDetails.getCena());
        ostaliResursi.setTip(ostaliResursiDetails.getTip());
        ostaliResursi.setBoja(ostaliResursiDetails.getBoja());
        ostaliResursi.setStil(ostaliResursiDetails.getStil());
        ostaliResursi.setKolicina(ostaliResursiDetails.getKolicina());
        ostaliResursi.setDogadjajID(ostaliResursiDetails.getDogadjajID());

        OstaliResursi updatedOstaliResursi = ostaliResursiRepository.save(ostaliResursi);
        return ResponseEntity.ok(updatedOstaliResursi);

    }


    //delete
    @DeleteMapping("/ostaliResursi/{type}/{id}")
    public Map<String, Boolean> deleteOstaliResursi(@PathVariable Long id,@PathVariable String type) {

        OstaliResursi ostaliResursi = ostaliResursiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ostali resursi does not exist with id:" + id));

        ostaliResursiRepository.delete(ostaliResursi);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    //get by dogadjajID
    @GetMapping("/ostaliResursi/dogadjaj/{type}/{dogadjajID}")
    public List<OstaliResursi> getOstaliResursiByDogadjajId(@PathVariable("type") String type, @PathVariable("dogadjajID") long dogadjajID){
        if(type.equals("organizator")){
            return ostaliResursiRepository.findByDogadjajID(dogadjajID);}
        return null;
    }

}
