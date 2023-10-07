package com.security.Electroplanet.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private OrderHistory order; // Reference to the order associated with this invoice
    private double amount;
    private String billingAddress;
    private String paymentMethod;

    // Add any additional invoice-related fields as needed
}
