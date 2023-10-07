package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.CartProduct;
import com.security.Electroplanet.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/cartProducts")
@CrossOrigin

public class CartProductController {
    @Autowired
    private CartProductService cartProductService;
@GetMapping("/all")
    public List<CartProduct> getAllCartProduct(){
    return  cartProductService.findAll();
}
}
