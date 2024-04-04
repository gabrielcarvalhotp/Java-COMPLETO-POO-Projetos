package com.gabrielcarvalhotp.course.services;

import com.gabrielcarvalhotp.course.entities.Order;
import com.gabrielcarvalhotp.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    public List<Order> listAll() {
        return OrderRepository.findAll();
    }

    public Order findById(Integer id) {
        return OrderRepository.findById(id).get();
    }
}
