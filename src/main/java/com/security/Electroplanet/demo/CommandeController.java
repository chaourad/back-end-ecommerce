package com.security.Electroplanet.demo;


import com.security.Electroplanet.entites.Commande;
import com.security.Electroplanet.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commande")
@CrossOrigin

public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    // Endpoint to get all commands

@GetMapping("/all")
public List<Commande> gettAllCommande(){
    return  commandeService.findAll();
}

    // Endpoint to create a new command
    @PostMapping("/create")
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    // Endpoint to get a command by ID
    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable int id) {
        return commandeService.findById(id);
    }
}
