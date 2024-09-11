package com.kasim.bookstore.controller;


import com.kasim.OrderNotFoundException;
import com.kasim.bookstore.model.Order;
import com.kasim.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


    @GetMapping("{id}")
    public Order getOrderById(@PathVariable Long id){
        return Optional.ofNullable(orderService.getOrderbyId(id))
                .orElseThrow(() -> new OrderNotFoundException("Order Not found with id: " + id));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order savedOrder= orderService.saveOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> modifyOrder(@PathVariable Long id, @RequestBody Order order){
        Optional<Order> orderbyId = Optional.ofNullable(orderService.getOrderbyId(id));
        if(!orderbyId.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Order modifiedOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(modifiedOrder , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void cancelOrder(@PathVariable Long id){
        orderService.cancelOrder(id);
    }
}
