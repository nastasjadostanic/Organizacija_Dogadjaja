package stasaaleksadavid.isabackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Admin;
import stasaaleksadavid.isabackend.model.ClientPenalties;
import stasaaleksadavid.isabackend.repository.ClientPenaltiesRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http//localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ClientPenaltiesController {

    private ClientPenaltiesRepository clientPenaltiesRepository;

    @GetMapping("/clientPenalties")
    public List<ClientPenalties> getAllClientPenalties(){return clientPenaltiesRepository.findAll();}

    @PostMapping("/clientPenalties")
    public  ClientPenalties createClientPenalty(@RequestBody ClientPenalties clientPenalties){
        return clientPenaltiesRepository.save(clientPenalties);
    }

    @GetMapping("/clientPenalties/{id}")
    public ResponseEntity<ClientPenalties> getClientPenaltyById(@PathVariable Long id){
        ClientPenalties clientPenalties = clientPenaltiesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client penalty does not exist with id:"+ id));
        return ResponseEntity.ok(clientPenalties);
    }

    @DeleteMapping("/clientPenalties/{id}")
    public Map<String, Boolean> deleteClientPenalty(@PathVariable Long id){

        ClientPenalties clientPenalties = clientPenaltiesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client penalty does not exist with id:"+ id));

        clientPenaltiesRepository.delete(clientPenalties);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

}
