package com.Backend.CampusOrdering.repository;

import com.Backend.CampusOrdering.model.Orders;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderInterface extends JpaRepository<Orders, Integer> {
    
}