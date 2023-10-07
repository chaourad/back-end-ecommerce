package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
    Facture findById(int id);
}
