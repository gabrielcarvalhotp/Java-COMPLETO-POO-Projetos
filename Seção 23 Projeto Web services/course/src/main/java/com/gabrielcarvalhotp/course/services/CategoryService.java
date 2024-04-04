package com.gabrielcarvalhotp.course.services;

import com.gabrielcarvalhotp.course.entities.Category;
import com.gabrielcarvalhotp.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> listAll() {
        return CategoryRepository.findAll();
    }

    public Category findById(Integer id) {
        return CategoryRepository.findById(id).get();
    }
}
