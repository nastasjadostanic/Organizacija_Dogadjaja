package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Organizator;
import stasaaleksadavid.isabackend.repository.OrganizatorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OrganizatorController {

    @Autowired
    private OrganizatorRepository organizatorRepository;

    //get all

    @GetMapping("/organizatori")
    public List<Organizator> getAllOrganizatori(){return organizatorRepository.findAll();}

    //create
    @PostMapping("/organizatori")
    public  Organizator createOrganizator(@RequestBody Organizator organizator){
        return organizatorRepository.save(organizator);
    }

    //get by id
    @GetMapping("/organizatori/{id}")
    public ResponseEntity <Organizator> getOrganizatorById(@PathVariable Long id){
        Organizator organizator = organizatorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organizator does not exist with id:"+ id));
        return ResponseEntity.ok(organizator);
    }

    //update
    @PutMapping("/organizatori/{id}")
    public ResponseEntity<Organizator> updateOrganizator(@PathVariable Long id,@RequestBody Organizator organizatorDetails){
        Organizator organizator = organizatorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organizator does not exist with id:"+ id));

        organizator.setLozinka(organizatorDetails.getLozinka());
        organizator.setIme(organizatorDetails.getIme());
        organizator.setPrezime(organizatorDetails.getPrezime());
        organizator.setDatumRodjenja(organizatorDetails.getDatumRodjenja());
        organizator.setEmail(organizatorDetails.getEmail());
        organizator.setTelefon(organizatorDetails.getTelefon());
        organizator.setAdresa(organizatorDetails.getAdresa());


        Organizator updatedOrganizator = organizatorRepository.save(organizator);
        return ResponseEntity.ok(updatedOrganizator);
    }


    //delete
    @DeleteMapping("/organizatori/{id}")
    public Map<String, Boolean> deleteOrganizator(@PathVariable Long id){

        Organizator organizator = organizatorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organizator does not exist with id:"+ id));

        organizatorRepository.delete(organizator);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
}
