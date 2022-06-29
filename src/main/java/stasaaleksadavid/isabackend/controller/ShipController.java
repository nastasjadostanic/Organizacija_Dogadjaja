package stasaaleksadavid.isabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.CottageFreeAppointment;
import stasaaleksadavid.isabackend.model.Ship;
import stasaaleksadavid.isabackend.repository.ShipRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ShipController {

    @Autowired
    private ShipRepository shipRepository;

    //get all

    @GetMapping("/ships/{type}")
    public List<Ship> getAllShips(@PathVariable String type){
        if(type.equals("admin") || type.equals("main_admin")||type.equals("ship_owner")){
        return shipRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/ships/{type}")
    public  Ship createShip(@PathVariable String type,@RequestBody Ship ship){
        if(type.equals("admin") || type.equals("main_admin")||type.equals("ship_owner")) {
            return shipRepository.save(ship);
        }
        else return null;
    }

    //get by id
    @GetMapping("/ships/{type}/{id}")
    public ResponseEntity <Ship> getShipById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("admin") || type.equals("main_admin")||type.equals("ship_owner")) {
            Ship ship = shipRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship does not exist with id:" + id));
            return ResponseEntity.ok(ship);
        }
        else return null;
    }

    //update
    @PutMapping("/ships/{type}/{id}")
    public ResponseEntity<Ship> updateShip(@PathVariable String type,@PathVariable Long id,@RequestBody Ship shipDetails){
        if(type.equals("admin") || type.equals("main_admin")||type.equals("ship_owner")) {
            Ship ship = shipRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship does not exist with id:" + id));

            ship.setOwnerId(shipDetails.getOwnerId());
            ship.setName(shipDetails.getName());
            ship.setType(shipDetails.getType());
            ship.setLength(shipDetails.getLength());
            ship.setNumberOfEngines(shipDetails.getNumberOfEngines());
            ship.setHp(shipDetails.getHp());
            ship.setTopSpeed(shipDetails.getTopSpeed());
            ship.setNavigation(shipDetails.getNavigation());
            ship.setAddress(shipDetails.getAddress());
            ship.setDescription(shipDetails.getDescription());
            ship.setCapacity(shipDetails.getCapacity());
            ship.setRules(shipDetails.getRules());
            ship.setFishingEquipment(shipDetails.getFishingEquipment());


            Ship updatedShip = shipRepository.save(ship);
            return ResponseEntity.ok(updatedShip);
        }
        else return null;
    }


    //delete
    @DeleteMapping("/ships/{type}/{id}")
    public Map<String, Boolean> deleteShip(@PathVariable String type,@PathVariable Long id){
        if(type.equals("admin") || type.equals("main_admin")||type.equals("ship_owner")){


        Ship ship = shipRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ship does not exist with id:"+ id));

        shipRepository.delete(ship);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }
    @GetMapping("/ships/owner/{type}/{ownerid}")
    public List<Ship> getShipsByOwnerId(@PathVariable String type,@PathVariable Long ownerid) {
        if(type.equals("admin") || type.equals("main_admin")||type.equals("ship_owner")) {
            return shipRepository.findByOwnerId(ownerid);
        }
        else return null;
    }
}
