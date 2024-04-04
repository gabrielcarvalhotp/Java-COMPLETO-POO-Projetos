package com.gabrielcarvalhotp.course.repositories;


import com.gabrielcarvalhotp.course.entities.Category;
import com.gabrielcarvalhotp.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
