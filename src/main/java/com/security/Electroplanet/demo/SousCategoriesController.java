package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.Produit;
import com.security.Electroplanet.entites.SousCategories;
import com.security.Electroplanet.service.SousCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController

@RequestMapping("/api/v1/sous-categories")
public class SousCategoriesController {
    @Autowired
    private SousCategoriesService service;
    private final List<SousCategories> sousCategories = new ArrayList<>(); // Remplacez par votre propre liste de sous-catégories

    @GetMapping("/all")
    public List<SousCategories> getsouscategories(){
        return service.findAll();
    }
    @GetMapping("/{categorieId}")
    public List<SousCategories> getSousCategoriesByCategorieId(@PathVariable int categorieId) {
        return service.findByCategories(categorieId);
    }
}
