package com.example.artemis.service.impl;

import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.repository.AuthorRepository;
import com.example.artemis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<List<AuthorEntity>> getAllAuthors(){
        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

    public


}
