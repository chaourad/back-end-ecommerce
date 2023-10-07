package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.CartProductRepository;
import com.security.Electroplanet.entites.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductService implements Idao<CartProduct> {
@Autowired
private CartProductRepository cartProductRepository;
    @Override
    public CartProduct save(CartProduct o) {
        return cartProductRepository.save(o);
    }

    @Override
    public CartProduct findById(int id) {
        return cartProductRepository.findById(id);
    }

    @Override
    public void delete(CartProduct o) {
cartProductRepository.delete(o);
    }

    @Override
    public void update(CartProduct o) {
cartProductRepository.save(o);
    }

    @Override
    public List<CartProduct> findAll() {
        return cartProductRepository.findAll();
    }
}
