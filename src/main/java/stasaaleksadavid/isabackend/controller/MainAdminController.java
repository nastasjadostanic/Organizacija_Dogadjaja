package stasaaleksadavid.isabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stasaaleksadavid.isabackend.model.MainAdmin;
import stasaaleksadavid.isabackend.repository.MainAdminRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MainAdminController {

    @Autowired
    private MainAdminRepository mainAdminRepository;

    //get all
    @GetMapping("/mainadmins")
    public List<MainAdmin> getAllMainAdmins(){return mainAdminRepository.findAll();}


}
