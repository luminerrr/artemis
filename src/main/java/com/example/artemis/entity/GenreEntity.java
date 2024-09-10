package com.example.artemis.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Setter
@Getter

public class GenreEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

//    @Column(name = "description", nullable = false)
//    @JsonProperty("description")
//    private String description;

}
