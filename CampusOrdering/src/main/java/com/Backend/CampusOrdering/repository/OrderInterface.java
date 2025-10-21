package com.Backend.CampusOrdering.repository;

import com.Backend.CampusOrdering.model.Order;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderInterface extends JpaRepository<Order, Integer> {
    @Query("SELECT MAX(u.id) FROM Order u")
    int getMaxId();
}