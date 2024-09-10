package com.example.artemis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artemis.dto.CreateBookRequestDto;
import com.example.artemis.entity.BookEntity;
import com.example.artemis.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping()
  public ResponseEntity<List<BookEntity>> getAllBooks() {
      System.out.println("halo saya karta");
      
      return bookService.getAllBooks();
  }

  @PostMapping()
  public ResponseEntity<BookEntity> createNewBook(@RequestBody CreateBookRequestDto dto) {
      //TODO: process POST request
    
      return bookService.createNewBook(dto);
  }
  
  
}
