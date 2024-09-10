package com.example.artemis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.artemis.dto.CreateBookRequestDto;
import com.example.artemis.entity.BookEntity;

public interface BookService {
  ResponseEntity<Object> getAllBooks();
  ResponseEntity <Object> createNewBook(CreateBookRequestDto book);
  ResponseEntity <BookEntity> getBookById(Long id);
  ResponseEntity <String> deleteBook(Long id);
  ResponseEntity <BookEntity> updateBook(Long id, CreateBookRequestDto book);
  ResponseEntity <List<BookEntity>> searchBooks(String title, String author, String genre);
}
