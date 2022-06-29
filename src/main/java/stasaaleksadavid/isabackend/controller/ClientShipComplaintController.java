package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Admin;
import stasaaleksadavid.isabackend.model.ClientShipComplaint;
import stasaaleksadavid.isabackend.repository.ClientShipComplaintRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ClientShipComplaintController {

    @Autowired
    private ClientShipComplaintRepository clientShipComplaintRepository;

    @GetMapping("/shipComplaints")
    public List<ClientShipComplaint> getAllShipComplaints() {return clientShipComplaintRepository.findAll();}

    @PostMapping("/shipComplaints")
    public ClientShipComplaint createShipComplaint(@RequestBody ClientShipComplaint clientShipComplaint) {return clientShipComplaintRepository.save(clientShipComplaint);}

    @GetMapping("/shipComplaints/{id}")
    public ResponseEntity<ClientShipComplaint> getShipComplaintById(@PathVariable Long id){
        ClientShipComplaint clientShipComplaint = clientShipComplaintRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship complaint  does not exist with id:"+ id));
        return ResponseEntity.ok(clientShipComplaint);
    }

    @DeleteMapping("/shipComplaints/{id}")
    public Map<String, Boolean> deleteShipComplaint(@PathVariable Long id){

        ClientShipComplaint ClientShipComplaint = clientShipComplaintRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship complaint does not exist with id:"+ id));

        clientShipComplaintRepository.delete(ClientShipComplaint);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

}
