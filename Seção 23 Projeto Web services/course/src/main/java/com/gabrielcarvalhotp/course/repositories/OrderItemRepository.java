package com.gabrielcarvalhotp.course.repositories;


import com.gabrielcarvalhotp.course.entities.Category;
import com.gabrielcarvalhotp.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
