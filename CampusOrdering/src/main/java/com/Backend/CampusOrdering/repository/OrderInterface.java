package com.Backend.CampusOrdering.repository;

import com.Backend.CampusOrdering.model.Order;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderInterface extends JpaRepository<Order, Integer> {
    
}