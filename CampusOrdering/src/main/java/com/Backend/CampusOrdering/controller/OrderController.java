package com.Backend.CampusOrdering.controller;

import com.Backend.CampusOrdering.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {
 
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/placeOrder")
    public Map<String, Object> placeOrder(@RequestParam String studentnum, @RequestParam String ordermessage)
    {
        return orderService.placeOrder(studentnum, ordermessage);
    }

}
