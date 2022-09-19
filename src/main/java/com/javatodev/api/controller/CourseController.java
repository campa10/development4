package com.javatodev.api.controller;

import com.javatodev.api.model.Course;
import com.javatodev.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Course>> readProducts () {
        return ResponseEntity.ok(productService.readProducts());
    }
}
