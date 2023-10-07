package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.OrderedProduct;
import com.security.Electroplanet.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/OrderProduct")
@CrossOrigin

public class OrderedProductController {
    @Autowired
    private OrderedProductService orderedProductService;

    @GetMapping("/all")
    public List<OrderedProduct> getAllOrderProduct(){
        return orderedProductService.findAll();
    }
}
