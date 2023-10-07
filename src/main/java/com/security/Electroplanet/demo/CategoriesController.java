package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.Categorie;
import com.security.Electroplanet.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin

public class CategoriesController {
    @Autowired
    private CategorieService categorieService;


    @GetMapping("/all")
    public List<Categorie> get(){
        return categorieService.findAll();
    }

    @PostMapping("/save")
    public Categorie save(@RequestBody Categorie categorie){
        return categorieService.save(categorie);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable (required = true) String id){
        Categorie categorie = categorieService.findById(Integer.parseInt(id));
        categorieService.delete(categorie);
    }
    @GetMapping("/{id}")
    public Categorie findCategory(@PathVariable int id){
        return categorieService.findById(id);
    }
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Categorie categorie) {
        Categorie existingCategorie = categorieService.findById(categorie.getId());
        if (existingCategorie != null) {
            // Mettez à jour la catégorie avec les données de la requête
            existingCategorie.setNom(categorie.getNom()); // Exemple de mise à jour d'un champ, ajustez selon vos besoins
            categorieService.save(existingCategorie);
            return ResponseEntity.ok("Catégorie mise à jour avec succès");
        } else {
            return ResponseEntity.notFound().build(); // Catégorie non trouvée, renvoie une réponse 404
        }
    }


}
