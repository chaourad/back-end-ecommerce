package com.security.Electroplanet.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SousCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String image;
    @JsonIgnore
    @OneToMany( mappedBy = "souscategorie" , fetch = FetchType.EAGER)
    private List<Produit> produits;
    @ManyToOne
    private Categorie categorie;
}
