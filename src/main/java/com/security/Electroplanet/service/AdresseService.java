package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.AdresseRepository;
import com.security.Electroplanet.entites.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdresseService implements Idao<Adresse> {
    @Autowired
    private AdresseRepository adresseRepository;

    @Override
    public Adresse save(Adresse o) {
        return adresseRepository.save(o);
    }

    @Override
    public Adresse findById(int id) {
        return adresseRepository.findById(id);
    }

    @Override
    public void delete(Adresse o) {
    adresseRepository.delete(o);
    }

    @Override
    public void update(Adresse o) {

    }

    @Override
    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }
}
