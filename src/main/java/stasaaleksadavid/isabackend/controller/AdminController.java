package stasaaleksadavid.isabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.Admin;
import stasaaleksadavid.isabackend.repository.AdminRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    //get all

    @GetMapping("/admins")
    public List<Admin> getAllAdmins(){return adminRepository.findAll();}

    //create
    @PostMapping("/admins")
    public  Admin createAdmin(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }

    //get by id
    @GetMapping("/admins/{id}")
    public ResponseEntity <Admin> getAdminById(@PathVariable Long id){
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin does not exist with id:"+ id));
        return ResponseEntity.ok(admin);
    }

   //update
    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,@RequestBody Admin adminDetails){
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin does not exist with id:"+ id));

        admin.setPassword(adminDetails.getPassword());
        admin.setFirstName(adminDetails.getFirstName());
        admin.setLastName(adminDetails.getLastName());
        admin.setDateOfBirth(adminDetails.getDateOfBirth());
        admin.setEmail(adminDetails.getEmail());
        admin.setPhoneNumber(adminDetails.getPhoneNumber());
        admin.setAddress(adminDetails.getAddress());
        admin.setCity(adminDetails.getCity());
        admin.setCountry(adminDetails.getCountry());

        Admin updatedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }


    //delete
    @DeleteMapping("/admins/{id}")
    public Map<String, Boolean> deleteAdmin(@PathVariable Long id){

        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin does not exist with id:"+ id));

        adminRepository.delete(admin);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
}
