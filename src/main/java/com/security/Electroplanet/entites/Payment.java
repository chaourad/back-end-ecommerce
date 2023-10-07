package com.security.Electroplanet.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user; // Reference to the user making the payment

    private double amount;
    private String paymentMethod; // e.g., "Credit Card", "PayPal", etc.
    private String paymentStatus; // e.g., "Pending", "Paid", "Failed", etc.

    // Add additional payment-related fields as needed
}
