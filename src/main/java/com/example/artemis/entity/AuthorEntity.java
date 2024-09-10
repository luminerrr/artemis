package com.example.artemis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "authors")
@Setter
@Getter

public class AuthorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

//    @Column(name = "age", nullable = false)
//    @JsonProperty("age")
//    private Integer age;

    @Column(name = "bio", nullable = false)
    @JsonProperty("bio")
    private String bio;

}
