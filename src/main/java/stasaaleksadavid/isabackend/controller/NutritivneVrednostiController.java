package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;

import stasaaleksadavid.isabackend.model.NutritivneVrednosti;
import stasaaleksadavid.isabackend.repository.NutritivneVrednostiRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class NutritivneVrednostiController {
    @Autowired
    private NutritivneVrednostiRepository nutritivneVrednostiRepository;

    //get all

    @GetMapping("/nutritivnevrednosti/{type}")
    public List<NutritivneVrednosti> getAllNutritivneVrednostis(@PathVariable String type){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")) {
            return nutritivneVrednostiRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/nutritivnevrednosti/{type}")
    public  NutritivneVrednosti createNutritivneVrednosti(@PathVariable String type,@RequestBody NutritivneVrednosti nutritivneVrednosti){
        if(type.equals("Kuvar") || type.equals("Konobar")) {
            return nutritivneVrednostiRepository.save(nutritivneVrednosti);
        }
        else{return null;}
    }

    //get by id

    @GetMapping("/nutritivnevrednosti/id/{type}/{id}")
    public ResponseEntity<NutritivneVrednosti> getNutritivneVrednostiById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")) {
            NutritivneVrednosti nutritivneVrednosti = nutritivneVrednostiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NutritivneVrednosti does not exist with id:" + id));
            return ResponseEntity.ok(nutritivneVrednosti);
        }
        else return null;

    }
    //update
    @PutMapping("/nutritivnevrednosti/{type}/{id}")
    public ResponseEntity<NutritivneVrednosti> updateNutritivneVrednosti(@PathVariable String type,@PathVariable Long id,@RequestBody NutritivneVrednosti nutritivneVrednostiDetails){

        if(type.equals("Kuvar") || type.equals("Konobar")){
            NutritivneVrednosti nutritivneVrednosti = nutritivneVrednostiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NutritivneVrednosti does not exist with id:" + id));

            nutritivneVrednosti.setEnergija(nutritivneVrednostiDetails.getEnergija());
            nutritivneVrednosti.setMasti(nutritivneVrednostiDetails.getMasti());
            nutritivneVrednosti.setZasiceneMasti(nutritivneVrednostiDetails.getZasiceneMasti());
            nutritivneVrednosti.setUH(nutritivneVrednostiDetails.getUH());
            nutritivneVrednosti.setSecer(nutritivneVrednostiDetails.getSecer());
            nutritivneVrednosti.setVlakna(nutritivneVrednostiDetails.getVlakna());
            nutritivneVrednosti.setProteini(nutritivneVrednostiDetails.getProteini());
            nutritivneVrednosti.setSo(nutritivneVrednostiDetails.getSo());
            nutritivneVrednosti.setHranaId(nutritivneVrednostiDetails.getHranaId());

            NutritivneVrednosti updatedNutritivneVrednosti = nutritivneVrednostiRepository.save(nutritivneVrednosti);
            return ResponseEntity.ok(updatedNutritivneVrednosti);
        }
        else{return null;}
    }
    //delete
    @DeleteMapping("/nutritivnevrednosti/{type}/{id}")
    public Map<String, Boolean> deleteNutritivneVrednosti(@PathVariable Long id,@PathVariable String type) {
        if(type.equals("Kuvar") || type.equals("Konobar")) {
            NutritivneVrednosti nutritivneVrednosti = nutritivneVrednostiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NutritivneVrednosti does not exist with id:" + id));

            nutritivneVrednostiRepository.delete(nutritivneVrednosti);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }
 //get by hranaId
    @GetMapping("/nutritivnevrednosti/hrana/{type}/{hranaId}")
    public NutritivneVrednosti getNutritivneVrednostiByHranaId( @PathVariable("type") String type, @PathVariable("hranaId") long hranaId){
        if(type.equals("Kuvar") || type.equals("Gost") || type.equals("Konobar")){
            NutritivneVrednosti loggedNutritivneVrednosti = nutritivneVrednostiRepository.findByHranaId(hranaId);
            return loggedNutritivneVrednosti;}

        return null;
    }


}
