package com.example.artemis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.artemis.dto.BookDto;
import com.example.artemis.dto.CreateBookRequestDto;
import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.entity.BookEntity;
import com.example.artemis.entity.GenreEntity;
import com.example.artemis.repository.AuthorRepository;
import com.example.artemis.repository.BookRepository;
import com.example.artemis.repository.GenreRepository;
import com.example.artemis.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private GenreRepository genreRepository;


  @Override
  public ResponseEntity<List<BookEntity>> getAllBooks() {
    List<BookEntity> books = bookRepository.findAll();

    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<BookEntity> getBookById(Long id) {
    // TODO: Handle null
    BookEntity book = bookRepository.findById(id).orElse(null);

    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @Override
  public ResponseEntity <BookEntity> createNewBook(CreateBookRequestDto book) {
    Optional<AuthorEntity> author = authorRepository.findById(book.getAuthor_id());
    Optional<GenreEntity> genre = genreRepository.findById(book.getGenre_id());
    if (author.isPresent() && genre.isPresent()) {
      BookEntity saveBook = new BookEntity();
      saveBook.setTitle(book.getTitle());
      saveBook.setAuthor(author.get());
      saveBook.setGenre(genre.get());
      saveBook.setPublished_date(book.getPublished_date());
      saveBook.setIsbn(book.getIsbn());
      BookEntity saved = bookRepository.save(saveBook);
      return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);


  }
  
}
