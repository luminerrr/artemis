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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




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

  @PutMapping("/{id}")
  public ResponseEntity<BookEntity> updateBook(@PathVariable(name = "id") Long id, @RequestBody CreateBookRequestDto dto) {
      
      return bookService.updateBook(id, dto);
  }
  
  
  @GetMapping("/search")
  public ResponseEntity<List<BookEntity>> searchBooks(
          @RequestParam (name = "title", required = false, defaultValue = "") String title,
          @RequestParam (name = "author", required = false, defaultValue = "") String author,
          @RequestParam (name = "genre", required = false, defaultValue = "") String genre
  ) {
      return bookService.searchBooks(title, author, genre);
  }

}
