package com.example.artemis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Setter
@Getter

public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "age", nullable = false)
    @JsonProperty("age")
    private Integer age;

    @Column(name = "description", nullable = false)
    @JsonProperty("description")
    private String description;

}
