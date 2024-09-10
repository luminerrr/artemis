package com.example.artemis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.artemis.entity.BookEntity;

public interface BookService {
  ResponseEntity <List<BookEntity>> getAllBooks();
  ResponseEntity <BookEntity> createNewBook();
}
