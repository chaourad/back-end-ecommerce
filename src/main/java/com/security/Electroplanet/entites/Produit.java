package com.security.Electroplanet.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String image;
    private Date date_created;
    private int quantite;
    private double prix;
    @ManyToOne
    private SousCategories souscategorie;
    @OneToMany(mappedBy = "product")
    private List<OrderedProduct> orderedProducts;

    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private  List<CartProduct> cartProducts;
    
}
