package com.example.artemis.controller;

import com.example.artemis.entity.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    //@Autowired

    @GetMapping
    public List<AuthorEntity> findAll() { }
}
