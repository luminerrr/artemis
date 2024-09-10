package com.example.artemis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.artemis.entity.BookEntity;
import com.example.artemis.repository.BookRepository;
import com.example.artemis.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public ResponseEntity<List<BookEntity>> getAllBooks() {
    List<BookEntity> books = bookRepository.findAll();

    return new ResponseEntity<>(books, HttpStatus.OK);
  }

//  @Override
//  public ResponseEntity<BookEntity> getBookById(Long id) {
//    // TODO: Handle null
//    BookEntity book = bookRepository.findById(id).orElse(null);
//
//    return new ResponseEntity<>(book, HttpStatus.OK);
//  }
//
//  @Override
//  public ResponseEntity<BookEntity> createBook(BookEntity book) {
//
//  }

  @Override
  public ResponseEntity<List<BookEntity>> searchBooks(String title, String author, String genre) {
    List<BookEntity> searchedBooks = bookRepository.searchBooks(title, author, genre);
    if(searchedBooks.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.OK);
    }
    return new ResponseEntity<>(searchedBooks, HttpStatus.OK);
  }
  
}
