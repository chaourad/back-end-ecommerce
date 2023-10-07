package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.Facture;
import com.security.Electroplanet.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facture")
@CrossOrigin

public class FactureController {
    @Autowired
    private FactureService factureService;
    @GetMapping("/all")
    public List<Facture> findAllFactute(){
        return factureService.findAll();
    }
}
