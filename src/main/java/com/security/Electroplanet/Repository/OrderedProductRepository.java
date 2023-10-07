package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {
    OrderedProduct findById(int id);
}
