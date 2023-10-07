package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande , Integer> {
    Commande findById(int id);
}
