package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.Produit;
import com.security.Electroplanet.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin

public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @GetMapping("/all")
    public List<Produit> getpr(){
        return produitService.findAll();
    }
    @PostMapping("/save")
    public Produit save(@RequestBody Produit produit){
        return  produitService.save(produit);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produit> findProduit(@PathVariable int id){
        Produit produit = produitService.findById(id);
        if(produit == null){
            return ResponseEntity.notFound().build(); // Produit non trouvé, renvoie une réponse 404
        }
        return ResponseEntity.ok(produit); // Produit trouvé, renvoie une réponse 200 OK
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduit(@PathVariable int id){
        Produit produit = produitService.findById(id);
        produitService.delete(produit);
    }

}
