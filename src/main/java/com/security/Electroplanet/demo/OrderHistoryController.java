package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.OrderHistory;
import com.security.Electroplanet.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderHistory")
@CrossOrigin

public class OrderHistoryController {
    @Autowired(required = true)
    private OrderHistoryService orderHistoryService;

    @GetMapping("/all")
    public List<OrderHistory> findAllOrderHi(){
        return  orderHistoryService.findAll();
    }

    @GetMapping("/{id}")
    public OrderHistory findByIdOrder(int id){
        return orderHistoryService.findById(id);
    }
}
