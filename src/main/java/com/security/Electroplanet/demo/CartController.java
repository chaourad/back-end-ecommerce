package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.Cart;
import com.security.Electroplanet.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin

public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    public List<Cart> getAllCart(){
        return cartService.findAll();
    }
    @GetMapping("/{id}")
    public Cart findByIdCart(@PathVariable int id){
        return  cartService.findById(id);
    }
}
