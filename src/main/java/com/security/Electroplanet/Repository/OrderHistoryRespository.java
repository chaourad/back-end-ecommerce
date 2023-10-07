package com.security.Electroplanet.Repository;

import com.security.Electroplanet.entites.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRespository extends JpaRepository<OrderHistory, Integer> {
    OrderHistory findById(int id);
}
