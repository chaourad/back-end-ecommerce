package com.security.Electroplanet.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double unitPrice;
    @Column(name = "commande_id", insertable = false, updatable = false)
    private int commandeId;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    @JsonIgnore
    private Commande commande;
    @Column(name = "product_id", insertable = false, updatable = false)
    private int produitId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore

    private Produit product;

    private int quantity;

    // Getters et setters
}