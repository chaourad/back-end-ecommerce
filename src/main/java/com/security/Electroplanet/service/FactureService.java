package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.FactureRepository;
import com.security.Electroplanet.entites.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService implements Idao<Facture> {
    @Autowired
    private FactureRepository factureRepository;
    @Override
    public Facture save(Facture o) {
        return factureRepository.save(o);
    }

    @Override
    public Facture findById(int id) {
        return factureRepository.findById(id);
    }

    @Override
    public void delete(Facture o) {
        factureRepository.delete(o);
    }

    @Override
    public void update(Facture o) {

    }

    @Override
    public List<Facture> findAll() {
        return factureRepository.findAll();
    }
}
