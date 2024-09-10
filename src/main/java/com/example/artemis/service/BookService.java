package com.example.artemis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.artemis.dto.CreateBookRequestDto;
import com.example.artemis.entity.BookEntity;

public interface BookService {
  ResponseEntity <List<BookEntity>> getAllBooks();
  ResponseEntity <BookEntity> createNewBook(CreateBookRequestDto book);
  ResponseEntity <BookEntity> getBookById(Long id);
  ResponseEntity <String> deleteBook(Long id);
  ResponseEntity <BookEntity> updateBook(Long id, BookEntity book);
}
