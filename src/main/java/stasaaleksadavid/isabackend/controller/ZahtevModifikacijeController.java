package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.ZahtevModifikacije;
import stasaaleksadavid.isabackend.model.ZahtevResursa;
import stasaaleksadavid.isabackend.repository.ZahtevModifikacijeRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ZahtevModifikacijeController {
    @Autowired
    private ZahtevModifikacijeRepository zahtevModifikacijeRepository;

    //get all

    @GetMapping("/zahteviModifikacije")
    public List<ZahtevModifikacije> getAllSale(){return zahtevModifikacijeRepository.findAll();}

    //create
    @PostMapping("/zahteviModifikacije/{type}")
    public  ZahtevModifikacije createZahtevModifikacije(@PathVariable String type,@RequestBody ZahtevModifikacije zahtevModifikacije){
        return zahtevModifikacijeRepository.save(zahtevModifikacije);
    }

    //get by id
    @GetMapping("/zahteviModifikacije/{type}/{id}")
    public ResponseEntity <ZahtevModifikacije> getZahtevModifikacijeById(@PathVariable Long id){
        ZahtevModifikacije zahtevModifikacije = zahtevModifikacijeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev Modifikacije does not exist with id:"+ id));
        return ResponseEntity.ok(zahtevModifikacije);
    }

    //update
    @PutMapping("/zahteviModifikacije/{type}/{id}")
    public ResponseEntity<ZahtevModifikacije> updateZahtevModifikacije(@PathVariable String type,@PathVariable Long id,@RequestBody ZahtevModifikacije zahtevModifikacijeDetails){

        ZahtevModifikacije zahtevModifikacije = zahtevModifikacijeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev Modifikacije does not exist with id:" + id));

        zahtevModifikacije.setDatumZahteva(zahtevModifikacijeDetails.getDatumZahteva());
        zahtevModifikacije.setOpisZahteva(zahtevModifikacijeDetails.getOpisZahteva());
        zahtevModifikacije.setDogadjajID(zahtevModifikacijeDetails.getDogadjajID());
        zahtevModifikacije.setGostId(zahtevModifikacijeDetails.getGostId());

        ZahtevModifikacije updatedZahtevModifikacije = zahtevModifikacijeRepository.save(zahtevModifikacije);
        return ResponseEntity.ok(updatedZahtevModifikacije);

    }


    //delete
    @DeleteMapping("/zahteviModifikacije/{type}/{id}")
    public Map<String, Boolean> deleteZahtevModifikacije(@PathVariable Long id,@PathVariable String type) {

        ZahtevModifikacije zahtevModifikacije = zahtevModifikacijeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev Modifikacije does not exist with id:" + id));

        zahtevModifikacijeRepository.delete(zahtevModifikacije);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    //get all by gostId
    @GetMapping("/zahteviModifikacije/gostId/{type}/{id}")
    public List<ZahtevModifikacije> getAllZahtevByGostId(@PathVariable String type, @PathVariable Long id ){return zahtevModifikacijeRepository.findByGostId(id);}


}
