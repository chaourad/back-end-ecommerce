package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.ProduitRepository;
import com.security.Electroplanet.entites.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements Idao<Produit> {
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public Produit save(Produit o) {
        return produitRepository.save(o);
    }

    @Override
    public Produit findById(int id) {
        return produitRepository.findById(id);
    }

    @Override
    public void delete(Produit o) {
    produitRepository.delete(o);
    }

    @Override
    public void update(Produit o) {

    }


    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }
}
