package com.Backend.CampusOrdering.service;

import com.Backend.CampusOrdering.repository.OrderInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderInterface orderInterface;

    @Autowired
    public OrderService(OrderInterface orderInterface){
        this.orderInterface = orderInterface;
    }

    public String placeOrder(){
        return "";
    }
}
