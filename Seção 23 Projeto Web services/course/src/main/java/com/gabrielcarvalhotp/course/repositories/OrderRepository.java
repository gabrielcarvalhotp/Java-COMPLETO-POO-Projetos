package com.gabrielcarvalhotp.course.repositories;


import com.gabrielcarvalhotp.course.entities.Order;
import com.gabrielcarvalhotp.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
