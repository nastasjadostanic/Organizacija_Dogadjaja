package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Dogadjaj;
import stasaaleksadavid.isabackend.model.ZahtevResursa;
import stasaaleksadavid.isabackend.repository.ZahtevResursaRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ZahtevResursaController {
    @Autowired
    private ZahtevResursaRepository zahtevResursaRepository;

    //get all
    @GetMapping("/zahteviresursa")
    public List<ZahtevResursa> getAllSale(){return zahtevResursaRepository.findAll();}

    //create
    @PostMapping("/zahteviresursa/{type}")
    public  ZahtevResursa createZahtevResursa(@PathVariable String type,@RequestBody ZahtevResursa zahtevResursa){
        return zahtevResursaRepository.save(zahtevResursa);
    }

    //get by id
    @GetMapping("/zahteviresursa/{type}/{id}")
    public ResponseEntity <ZahtevResursa> getZahtevResursaById(@PathVariable Long id){
        ZahtevResursa zahtevResursa = zahtevResursaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev resursa does not exist with id:"+ id));
        return ResponseEntity.ok(zahtevResursa);
    }

    //update
    @PutMapping("/zahteviresursa/{type}/{id}")
    public ResponseEntity<ZahtevResursa> updateZahtevResursa(@PathVariable String type,@PathVariable Long id,@RequestBody ZahtevResursa zahtevResursaDetails){

        ZahtevResursa zahtevResursa = zahtevResursaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev resursa does not exist with id:" + id));

        zahtevResursa.setDatumZahteva(zahtevResursaDetails.getDatumZahteva());
        zahtevResursa.setTipResursa(zahtevResursaDetails.getTipResursa());
        zahtevResursa.setResursID(zahtevResursaDetails.getResursID());
        zahtevResursa.setGostId(zahtevResursaDetails.getGostId());
        zahtevResursa.setDogadjajID(zahtevResursaDetails.getDogadjajID());

        ZahtevResursa updatedZahtevResursa = zahtevResursaRepository.save(zahtevResursa);
        return ResponseEntity.ok(updatedZahtevResursa);

    }


    //delete
    @DeleteMapping("/zahteviresursa/{type}/{id}")
    public Map<String, Boolean> deleteZahtevResursa(@PathVariable Long id,@PathVariable String type) {

        ZahtevResursa zahtevResursa = zahtevResursaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev resursa does not exist with id:" + id));

        zahtevResursaRepository.delete(zahtevResursa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    //get all by gostId
    @GetMapping("/zahteviresursa/gostId/{type}/{id}")
    public List<ZahtevResursa> getAllZahtevByGostId(@PathVariable String type, @PathVariable Long id ){return zahtevResursaRepository.findByGostId(id);}


}
