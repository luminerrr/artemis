package com.example.artemis.service;

import com.example.artemis.entity.AuthorEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {

    ResponseEntity <List<AuthorEntity>> getAllAuthor();
    ResponseEntity<AuthorEntity> getAuthorById(Long id);
    ResponseEntity<String> deleteAuthor(Long id);
    ResponseEntity<AuthorEntity> saveAuthor(AuthorEntity author);
    AuthorEntity updateAuthor(AuthorEntity genre);
}
