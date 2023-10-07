package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.CartRepository;
import com.security.Electroplanet.entites.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService implements Idao<Cart> {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart save(Cart o) {
        return cartRepository.save(o);
    }

    @Override
    public Cart findById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void delete(Cart o) {
    cartRepository.delete(o);
    }

    @Override
    public void update(Cart o) {
cartRepository.save(o);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
}
