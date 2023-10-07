package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findById(int id);
}
