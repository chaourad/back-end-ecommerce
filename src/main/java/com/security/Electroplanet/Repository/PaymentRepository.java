package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
