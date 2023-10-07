package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.CategoriesRepository;
import com.security.Electroplanet.entites.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieService implements Idao<Categorie> {
   @Autowired
   private CategoriesRepository categoriesRepository;
    @Override
    public Categorie save(Categorie o) {
        return categoriesRepository.save(o);
    }

    @Override
    public Categorie findById(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public void delete(Categorie o) {
    categoriesRepository.delete(o);
    }

    @Override
    public void update(Categorie o) {
         categoriesRepository.save(o);

    }

    @Override
    public List<Categorie> findAll() {
        return categoriesRepository.findAll();
    }
}
