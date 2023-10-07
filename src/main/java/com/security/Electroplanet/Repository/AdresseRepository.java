package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse , Integer> {
    Adresse findById(int id);
}
