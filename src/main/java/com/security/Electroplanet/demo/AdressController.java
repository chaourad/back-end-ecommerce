package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.Adresse;
import com.security.Electroplanet.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adress")
@CrossOrigin

public class AdressController {
    @Autowired
    private AdresseService adresseService;
    @GetMapping("/all")
    public List<Adresse> get(){
        return adresseService.findAll();
    }
}
