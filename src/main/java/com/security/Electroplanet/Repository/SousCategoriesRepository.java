package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.SousCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SousCategoriesRepository extends JpaRepository<SousCategories, Integer> {
    SousCategories findById(int id);
    List<SousCategories> findByCategorieId(int categorieId);}
