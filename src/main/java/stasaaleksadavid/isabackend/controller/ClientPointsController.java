package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.*;
import stasaaleksadavid.isabackend.repository.ClientPointsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ClientPointsController {

    @Autowired
    private ClientPointsRepository clientPointsRepository;

    @GetMapping("/clientPoints")
    public List<ClientPoints> getAllClientPoints(){return clientPointsRepository.findAll();}

    @PostMapping("/clientPoints")
    public  ClientPoints createClientPoints(@RequestBody ClientPoints userPoints){
        return clientPointsRepository.save(userPoints);
    }

    @GetMapping("/clientPoints/{id}")
    public ResponseEntity<ClientPoints> getClientPointsById(@PathVariable Long id){
        ClientPoints clientPoints = clientPointsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client points does not exist with id:"+ id));
        return ResponseEntity.ok(clientPoints);
    }

    @DeleteMapping("/clientPoints/{id}")
    public Map<String, Boolean> deleteClientPoints(@PathVariable Long id){

        ClientPoints clientPoints = clientPointsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client points does not exist with id:"+ id));

        clientPointsRepository.delete(clientPoints);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
}
