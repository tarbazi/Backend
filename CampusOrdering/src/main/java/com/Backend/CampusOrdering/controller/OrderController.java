package com.Backend.CampusOrdering.controller;

import com.Backend.CampusOrdering.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONObject;

@RestController
public class OrderController {
 
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public JSONObject placeOrder(@RequestParam String studentNum, @RequestParam String orderMessage)
    {
        return orderService.placeOrder(studentNum, orderMessage);
    }

}
