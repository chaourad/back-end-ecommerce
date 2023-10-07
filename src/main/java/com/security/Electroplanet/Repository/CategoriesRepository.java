package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categorie, Integer> {
    Categorie findById(int id);
}
