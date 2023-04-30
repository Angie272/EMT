package com.example.emtlab.web;
import com.example.emtlab.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"/api/categories"})
public class CategoryController {
    @GetMapping
    public List<Category> findAll() {
        return Arrays.asList(Category.values().clone());
    }
}