package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Income;
import stasaaleksadavid.isabackend.repository.IncomeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;
    //get all

    @GetMapping("/income")
    public List<Income> getAllIncome(){return incomeRepository.findAll();}

    //create
    @PostMapping("/income")
    public  Income createIncome(@RequestBody Income income){
        return incomeRepository.save(income);
    }

    //get by id
    @GetMapping("/income/{type}/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("admin")|| type.equals("main_admin")){
        Income income = incomeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Income does not exist with id:"+ id));
        return ResponseEntity.ok(income);
        }
        else{return null;}
        }

    //update
    @PutMapping("/income/{type}/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id,@RequestBody Income incomeDetails,@PathVariable String type){
        if(type.equals("admin")|| type.equals("main_admin")){
        Income income = incomeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Income does not exist with id:"+ id));

        income.setIncomeFromReservations(incomeDetails.getIncomeFromReservations());
        income.setPercentageOfReservations(incomeDetails.getPercentageOfReservations());

        Income updatedIncome = incomeRepository.save(income);
        return ResponseEntity.ok(updatedIncome);
        }
        else{return null;}
        }


    //delete
    @DeleteMapping("/income/{id}")
    public Map<String, Boolean> deleteAdmin(@PathVariable Long id){

        Income income = incomeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Income does not exist with id:"+ id));

        incomeRepository.delete(income);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }


}
