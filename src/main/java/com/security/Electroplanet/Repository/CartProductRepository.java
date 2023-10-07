package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
    CartProduct findById(int id);
}
