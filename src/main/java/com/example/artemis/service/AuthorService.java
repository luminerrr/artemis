package com.example.artemis.service;

import com.example.artemis.entity.AuthorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {

    ResponseEntity <List<AuthorEntity>> getAllAuthor();
    ResponseEntity <AuthorEntity> getAuthorById(Long id);
    ResponseEntity <String> deleteAuthor(Long id);
    ResponseEntity <AuthorEntity> saveAuthor(AuthorEntity author);
    ResponseEntity <AuthorEntity> updateAuthor(Long id, AuthorEntity enity);
}
