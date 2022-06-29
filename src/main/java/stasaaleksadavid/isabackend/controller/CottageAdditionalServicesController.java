package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.CottageAdditionalServices;
import stasaaleksadavid.isabackend.repository.CottageAdditionalServicesRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CottageAdditionalServicesController {

    @Autowired
    private CottageAdditionalServicesRepository cottageAdditionalServicesRepository;

    //get all

    @GetMapping("/cottageadditionalservices")
    public List<CottageAdditionalServices> getAllCottageAdditionalServicess(){return cottageAdditionalServicesRepository.findAll();}

    //create
    @PostMapping("/cottageadditionalservices")
    public  CottageAdditionalServices createCottageAdditionalServices(@RequestBody CottageAdditionalServices cottageAdditionalServices){
        return cottageAdditionalServicesRepository.save(cottageAdditionalServices);
    }

    //get by id
    @GetMapping("/cottageadditionalservices/{id}")
    public ResponseEntity<CottageAdditionalServices> getCottageAdditionalServicesById(@PathVariable Long id){
        CottageAdditionalServices cottageAdditionalServices = cottageAdditionalServicesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageAdditionalServices does not exist with id:"+ id));
        return ResponseEntity.ok(cottageAdditionalServices);
    }

    //update
    @PutMapping("/cottageadditionalservices/{id}")
    public ResponseEntity<CottageAdditionalServices> updateCottageAdditionalServices(@PathVariable Long id,@RequestBody CottageAdditionalServices cottageAdditionalServicesDetails){
        CottageAdditionalServices cottageAdditionalServices = cottageAdditionalServicesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageAdditionalServices does not exist with id:"+ id));


        cottageAdditionalServices.setWifiPrice(cottageAdditionalServicesDetails.getWifiPrice());
        cottageAdditionalServices.setWifiInformation(cottageAdditionalServicesDetails.getWifiInformation());
        cottageAdditionalServices.setParkingPrice(cottageAdditionalServicesDetails.getParkingPrice());
        cottageAdditionalServices.setParkingInformation(cottageAdditionalServicesDetails.getParkingInformation());
        cottageAdditionalServices.setPetBedPrice(cottageAdditionalServicesDetails.getPetBedPrice());
        cottageAdditionalServices.setPetBedInformation(cottageAdditionalServicesDetails.getPetBedInformation());
        cottageAdditionalServices.setAirConditionerPrice(cottageAdditionalServicesDetails.getAirConditionerPrice());
        cottageAdditionalServices.setAirConditionerInformation(cottageAdditionalServicesDetails.getAirConditionerInformation());

        CottageAdditionalServices updatedCottageAdditionalServices = cottageAdditionalServicesRepository.save(cottageAdditionalServices);
        return ResponseEntity.ok(updatedCottageAdditionalServices);
    }


    //delete
    @DeleteMapping("/cottageadditionalservices/{id}")
    public Map<String, Boolean> deleteCottageAdditionalServices(@PathVariable Long id){

        CottageAdditionalServices cottageAdditionalServices = cottageAdditionalServicesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageAdditionalServices does not exist with id:"+ id));

        cottageAdditionalServicesRepository.delete(cottageAdditionalServices);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }


}
