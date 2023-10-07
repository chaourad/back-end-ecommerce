package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.OrderHistoryRespository;
import com.security.Electroplanet.entites.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderHistoryService implements Idao<OrderHistory> {
    @Autowired
    public OrderHistoryRespository orderHistoryRespository;
    @Override
    public OrderHistory save(OrderHistory o) {
        return orderHistoryRespository.save(o);
    }

    @Override
    public OrderHistory findById(int id) {
        return orderHistoryRespository.findById(id);
    }

    @Override
    public void delete(OrderHistory o) {
        orderHistoryRespository.delete(o);
    }

    @Override
    public void update(OrderHistory o) {

    }

    @Override
    public List<OrderHistory> findAll() {
        return orderHistoryRespository.findAll();
    }
}
