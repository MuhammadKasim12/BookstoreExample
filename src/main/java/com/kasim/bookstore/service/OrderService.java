package com.kasim.bookstore.service;

import com.kasim.bookstore.model.Order;
import com.kasim.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public  Order getOrderbyId(Long id){
        return orderRepository.getById(id);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public void cancelOrder(Long id){
        orderRepository.delete(orderRepository.getReferenceById(id));
    }

}
