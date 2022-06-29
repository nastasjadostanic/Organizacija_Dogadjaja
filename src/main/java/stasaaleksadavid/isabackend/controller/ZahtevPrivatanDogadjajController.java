package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.ZahtevPrivatanDogadjaj;
import stasaaleksadavid.isabackend.model.ZahtevResursa;
import stasaaleksadavid.isabackend.repository.ZahtevPrivatanDogadjajRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ZahtevPrivatanDogadjajController {
    @Autowired
    private ZahtevPrivatanDogadjajRepository zahtevPrivatanDogadjajRepository;

    //get all
    @GetMapping("/zahteviPrivatanDogadjaj")
    public List<ZahtevPrivatanDogadjaj> getAllZahteviZaPrivatanDogadjaj(){return zahtevPrivatanDogadjajRepository.findAll();}

    //create
    @PostMapping("/zahteviPrivatanDogadjaj/{type}")
    public  ZahtevPrivatanDogadjaj createZahtevPrivatanDogadjaj(@PathVariable String type,@RequestBody ZahtevPrivatanDogadjaj zahtevPrivatanDogadjaj){
        return zahtevPrivatanDogadjajRepository.save(zahtevPrivatanDogadjaj);
    }

    //get by id
    @GetMapping("/zahteviPrivatanDogadjaj/{type}/{id}")
    public ResponseEntity <ZahtevPrivatanDogadjaj> getZahtevPrivatanDogadjajById(@PathVariable Long id){
        ZahtevPrivatanDogadjaj zahtevPrivatanDogadjaj = zahtevPrivatanDogadjajRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev PrivatanDogadjaj does not exist with id:"+ id));
        return ResponseEntity.ok(zahtevPrivatanDogadjaj);
    }

    //update
    @PutMapping("/zahteviPrivatanDogadjaj/{type}/{id}")
    public ResponseEntity<ZahtevPrivatanDogadjaj> updateZahtevPrivatanDogadjaj(@PathVariable String type,@PathVariable Long id,@RequestBody ZahtevPrivatanDogadjaj zahtevPrivatanDogadjajDetails){

        ZahtevPrivatanDogadjaj zahtevPrivatanDogadjaj = zahtevPrivatanDogadjajRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev PrivatanDogadjaj does not exist with id:" + id));

        zahtevPrivatanDogadjaj.setDatumOdrzavanja(zahtevPrivatanDogadjajDetails.getDatumOdrzavanja());
        zahtevPrivatanDogadjaj.setVremeOdrzavanja(zahtevPrivatanDogadjajDetails.getVremeOdrzavanja());
        zahtevPrivatanDogadjaj.setTrajanje(zahtevPrivatanDogadjajDetails.getTrajanje());
        zahtevPrivatanDogadjaj.setVrsta(zahtevPrivatanDogadjajDetails.getVrsta());
        zahtevPrivatanDogadjaj.setBrojMesta(zahtevPrivatanDogadjajDetails.getBrojMesta());
        zahtevPrivatanDogadjaj.setOrganizator(zahtevPrivatanDogadjajDetails.getOrganizator());
        zahtevPrivatanDogadjaj.setLjudskiResursId(zahtevPrivatanDogadjajDetails.getLjudskiResursId());
        zahtevPrivatanDogadjaj.setOstaliResursId(zahtevPrivatanDogadjajDetails.getOstaliResursId());
        zahtevPrivatanDogadjaj.setGostId(zahtevPrivatanDogadjajDetails.getGostId());

        ZahtevPrivatanDogadjaj updatedZahtevPrivatanDogadjaj = zahtevPrivatanDogadjajRepository.save(zahtevPrivatanDogadjaj);
        return ResponseEntity.ok(updatedZahtevPrivatanDogadjaj);

    }


    //delete
    @DeleteMapping("/zahteviPrivatanDogadjaj/{type}/{id}")
    public Map<String, Boolean> deleteZahtevPrivatanDogadjaj(@PathVariable Long id,@PathVariable String type) {

        ZahtevPrivatanDogadjaj zahtevPrivatanDogadjaj = zahtevPrivatanDogadjajRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zahtev PrivatanDogadjaj does not exist with id:" + id));

        zahtevPrivatanDogadjajRepository.delete(zahtevPrivatanDogadjaj);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    //get all by gostId
    @GetMapping("/zahteviPrivatanDogadjaj/gostId/{type}/{id}")
    public List<ZahtevPrivatanDogadjaj> getAllZahtevByGostId(@PathVariable String type, @PathVariable Long id ){return zahtevPrivatanDogadjajRepository.findByGostId(id);}


}
