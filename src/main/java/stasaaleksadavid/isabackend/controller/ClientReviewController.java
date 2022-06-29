package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Admin;
import stasaaleksadavid.isabackend.model.ClientReview;
import stasaaleksadavid.isabackend.repository.ClientReviewRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ClientReviewController {
    @Autowired
    private ClientReviewRepository clientReviewRepository;

    //get all

    @GetMapping("/clientreviews/{type}")
    public List<ClientReview> getAllClientReviews(@PathVariable String type){
        if(type.equals("admin") || type.equals("main_admin")){
        return clientReviewRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/clientreviews/{type}")
    public  ClientReview createClientReview(@PathVariable String type,@RequestBody ClientReview clientReview){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")) {
            return clientReviewRepository.save(clientReview);
        }
        else return null;
    }

    //get by id
    @GetMapping("/clientreviews/{type}/{id}")
    public ResponseEntity<ClientReview> getClientReviewById(@PathVariable String type,@PathVariable Long id){
        ClientReview clientReview = clientReviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClientReview does not exist with id:"+ id));
        return ResponseEntity.ok(clientReview);
    }

    //update
    @PutMapping("/clientreviews/{type}/{id}")
    public ResponseEntity<ClientReview> updateClientReview(@PathVariable String type,@PathVariable Long id,@RequestBody ClientReview clientReviewDetails){
        ClientReview clientReview = clientReviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClientReview does not exist with id:"+ id));

        clientReview.setIdOfReceiver(clientReviewDetails.getIdOfReceiver());
        clientReview.setIdOfSender(clientReviewDetails.getIdOfSender());
        clientReview.setEmailOfReceiver(clientReviewDetails.getEmailOfReceiver());
        clientReview.setEmailOfSender(clientReviewDetails.getEmailOfSender());
        clientReview.setReviewMessage(clientReviewDetails.getReviewMessage());

        ClientReview updatedClientReview = clientReviewRepository.save(clientReview);
        return ResponseEntity.ok(updatedClientReview);
    }


    //delete
    @DeleteMapping("/clientreviews/delete/{type}/{id}")
    public Map<String, Boolean> deleteClientReview(@PathVariable String type,@PathVariable Long id){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")) {

            ClientReview clientReview = clientReviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClientReview does not exist with id:"+ id));

        clientReviewRepository.delete(clientReview);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else return null;
    }

}
