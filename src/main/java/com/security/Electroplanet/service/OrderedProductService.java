package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.OrderedProductRepository;
import com.security.Electroplanet.entites.OrderedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedProductService implements Idao<OrderedProduct> {
    @Autowired
    private OrderedProductRepository orderedProductRepository;
    @Override
    public OrderedProduct save(OrderedProduct o) {
        return orderedProductRepository.save(o);
    }

    @Override
    public OrderedProduct findById(int id) {
        return orderedProductRepository.findById(id);
    }

    @Override
    public void delete(OrderedProduct o) {
        orderedProductRepository.delete(o);
    }

    @Override
    public void update(OrderedProduct o) {
        orderedProductRepository.save(o);
    }

    @Override
    public List<OrderedProduct> findAll() {
        return orderedProductRepository.findAll();
    }
}
