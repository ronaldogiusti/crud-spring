package com.ronaldogiusti.crudspring.controller;

import java.util.List;
import java.util.Optional;

import com.ronaldogiusti.crudspring.model.Course;
import com.ronaldogiusti.crudspring.repository.CourseRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
//lombok creates a constructor with all attributes, Spring instanciates those attributes
@AllArgsConstructor
public class CourseController {
    
    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("{id}")
    public Course listById(@PathVariable Long id) {
        Optional<Course> optional = courseRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found!");
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}
