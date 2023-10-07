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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double totalAmount;
    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id") // Assurez-vous que le nom de la colonne est correct
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<OrderedProduct> orderedProducts;
}
