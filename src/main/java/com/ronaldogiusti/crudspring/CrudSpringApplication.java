package com.ronaldogiusti.crudspring;

import com.ronaldogiusti.crudspring.model.Course;
import com.ronaldogiusti.crudspring.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			Course course = new Course();
			course.setName("Angular with Spring");
			course.setCategory("front-end");
			courseRepository.save(course);
		};
	}
}
