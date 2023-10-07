package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.CommandeRepository;
import com.security.Electroplanet.entites.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService implements Idao<Commande> {
    @Autowired
    private CommandeRepository commandeRepository;
    @Override
    public Commande save(Commande o) {
        return commandeRepository.save(o);
    }

    @Override
    public Commande findById(int id) {
        return commandeRepository.findById(id);
    }

    @Override
    public void delete(Commande o) {
    commandeRepository.delete(o);
    }

    @Override
    public void update(Commande o) {
commandeRepository.save(o);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }
}
