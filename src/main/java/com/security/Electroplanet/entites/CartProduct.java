package com.security.Electroplanet.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartProduct {
    //ligne panier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double unitPrice;
    @Column(name = "cart_id", insertable = false, updatable = false)
    private int cartId;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;
    @Column(name = "product_id", insertable = false, updatable = false)
    private int produitId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Produit produit;

    private int quantity;

}
