package com.example.artemis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.artemis.entity.BookEntity;

public interface BookService {
  ResponseEntity <List<BookEntity>> getAllBooks();
//  ResponseEntity <BookEntity> getBookById(Long id);
//  ResponseEntity <BookEntity> createNewBook(BookEntity book);
//  ResponseEntity <String> deleteBook(Long id);
//  ResponseEntity <BookEntity> updateBook(Long id, BookEntity book);
  ResponseEntity <List<BookEntity>> searchBooks(String title, String author, String genre);
}
