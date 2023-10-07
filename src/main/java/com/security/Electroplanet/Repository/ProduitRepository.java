package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    Produit findById(int id);
    //List<Produit> findByCategorie(String categorie);
    Produit findByTitle(String title);

}
