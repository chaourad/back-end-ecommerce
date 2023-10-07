package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.SousCategoriesRepository;
import com.security.Electroplanet.entites.SousCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousCategoriesService implements Idao<SousCategories> {
    @Autowired
    private SousCategoriesRepository sousCategoriesRepository;
    @Override
    public SousCategories save(SousCategories o) {
        return sousCategoriesRepository.save(o);
    }

    @Override
    public SousCategories findById(int id) {
        return sousCategoriesRepository.findById(id);
    }

    @Override
    public void delete(SousCategories o) {
        sousCategoriesRepository.delete(o);
    }

    @Override
    public void update(SousCategories o) {

    }

    @Override
    public List<SousCategories> findAll() {
        return sousCategoriesRepository.findAll();
    }

    public List<SousCategories> findByCategories(int categorieId){

        return sousCategoriesRepository.findByCategorieId(categorieId);
    }
}
