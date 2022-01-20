package com.ronaldogiusti.crudspring.model;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;
}
