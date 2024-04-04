package com.gabrielcarvalhotp.course.repositories;


import com.gabrielcarvalhotp.course.entities.Category;
import com.gabrielcarvalhotp.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
