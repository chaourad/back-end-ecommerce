package com.security.Electroplanet.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String adress1;

    @Column(columnDefinition = "TEXT")
    private  String adress2;
    private  String pays;
    private  int code_postal;
    @OneToOne
    private User user;


}
