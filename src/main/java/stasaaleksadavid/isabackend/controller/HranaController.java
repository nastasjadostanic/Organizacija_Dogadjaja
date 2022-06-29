package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Admin;
import stasaaleksadavid.isabackend.model.Hrana;
import stasaaleksadavid.isabackend.repository.HranaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class HranaController {
    @Autowired
    private HranaRepository hranaRepository;

    //get all

    @GetMapping("/hrana/{type}")
    public List<Hrana> getAllHranas(@PathVariable String type){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar"))  {
            return hranaRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/hrana/{type}")
    public  Hrana createHrana(@PathVariable String type,@RequestBody Hrana hrana){
        if(type.equals("Kuvar") || type.equals("Konobar")) {
            return hranaRepository.save(hrana);
        }
        else{return null;}
    }

    //get by id

    @GetMapping("/hrana/id/{type}/{id}")
    public ResponseEntity<Hrana> getHranaById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")) {
            Hrana hrana = hranaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hrana does not exist with id:" + id));
            return ResponseEntity.ok(hrana);
        }
        else return null;

    }
    //update
    @PutMapping("/hrana/{type}/{id}")
    public ResponseEntity<Hrana> updateHrana(@PathVariable String type,@PathVariable Long id,@RequestBody Hrana hranaDetails){

        if(type.equals("Kuvar") || type.equals("Konobar")){
            Hrana hrana = hranaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hrana does not exist with id:" + id));

            hrana.setNaziv(hranaDetails.getNaziv());
            hrana.setTipHrane(hranaDetails.getTipHrane());
            hrana.setCena(hranaDetails.getCena());
            hrana.setOcena(hranaDetails.getOcena());


            Hrana updatedHrana = hranaRepository.save(hrana);
            return ResponseEntity.ok(updatedHrana);
        }
        else{return null;}
    }
    //delete
    @DeleteMapping("/hrana/{type}/{id}")
    public Map<String, Boolean> deleteHrana(@PathVariable Long id,@PathVariable String type) {
        if(type.equals("Kuvar") ||type.equals("Konobar")){
            Hrana hrana = hranaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hrana does not exist with id:" + id));

            hranaRepository.delete(hrana);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }


    //get by TipHrane
    @GetMapping("/hrana/tipHrane/{type}/{tipHrane}")

    public List<Hrana> getAllHranaByTipHrane(@PathVariable String type,@PathVariable String tipHrane){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            {return hranaRepository.findByTipHrane(tipHrane);}}
        return null;
    }


    //get by Cena
    @GetMapping("/hrana/cena/{type}/{cena}")
    public List<Hrana> getAllHranaByCena(@PathVariable String type,@PathVariable Float cena){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            return hranaRepository.findByCena(cena);}
        return null;
        }

    //get by Ocena
    @GetMapping("/hrana/ocena/{type}/{ocena}")
    public List<Hrana> getAllHranaByOcena(@PathVariable String type,@PathVariable Float ocena){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            return hranaRepository.findByOcena(ocena);}
        return null;
    }


}

