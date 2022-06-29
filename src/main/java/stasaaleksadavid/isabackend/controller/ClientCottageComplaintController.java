package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.ClientCottageComplaints;

import stasaaleksadavid.isabackend.repository.ClientCottageComplaintRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ClientCottageComplaintController {

    @Autowired
    private ClientCottageComplaintRepository clientCottageComplaintRepository;

    @GetMapping("/cottageComplaints")
    public List<ClientCottageComplaints> getAllCottageComplaints() {return clientCottageComplaintRepository.findAll();}

    @PostMapping("/cottageComplaints")
    public ClientCottageComplaints createCottageComplaint(@RequestBody ClientCottageComplaints clientCottageComplaints) {return clientCottageComplaintRepository.save(clientCottageComplaints);}

    @GetMapping("/cottageComplaints/{id}")
    public ResponseEntity<ClientCottageComplaints> getCottageComplaintById(@PathVariable Long id){
        ClientCottageComplaints clientCottageComplaints = clientCottageComplaintRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cottage complaint  does not exist with id:"+ id));
        return ResponseEntity.ok(clientCottageComplaints);
    }

    @DeleteMapping("/cottageComplaints/{id}")
    public Map<String, Boolean> deleteCottageComplaint(@PathVariable Long id){

        ClientCottageComplaints clientCottageComplaints = clientCottageComplaintRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cottage complaint does not exist with id:"+ id));

        clientCottageComplaintRepository.delete(clientCottageComplaints);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

}
