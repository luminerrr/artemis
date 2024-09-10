package com.example.artemis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.artemis.dto.CreateBookRequestDto;
import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.entity.BookEntity;
import com.example.artemis.entity.GenreEntity;
import com.example.artemis.handler.ResponseHandler;
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
  public ResponseEntity<Object> getAllBooks() {
    List<BookEntity> books = bookRepository.findAll();

    return ResponseHandler.generateResponse("success", HttpStatus.OK, books.size(), books);
  }

  @Override
  public ResponseEntity<BookEntity> getBookById(Long id) {
    Optional<BookEntity> book = bookRepository.findById(id);
    if(!book.isPresent()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(book.get(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Object> createNewBook(CreateBookRequestDto book) {
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
      // return new ResponseEntity<>(saved, HttpStatus.OK);
      return ResponseHandler.generateResponse("success creating new", HttpStatus.OK, 1, saved);
    }

    return ResponseHandler.generateResponse("failed creating data", HttpStatus.NOT_FOUND, 0, null);
  }

  @Override
  public ResponseEntity<List<BookEntity>> searchBooks(String title, String author, String genre) {
    List<BookEntity> searchedBooks = bookRepository.searchBooks(title, author, genre);
    if (searchedBooks.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.OK);
    }
    return new ResponseEntity<>(searchedBooks, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> deleteBook(Long id) {
    if (bookRepository.findById(id).isPresent()) {
      bookRepository.deleteById(id);
      return new ResponseEntity<>("Success Delete", HttpStatus.OK);
    }

    return new ResponseEntity<>("Failed delete", HttpStatus.NOT_FOUND);
  }

  @Override
  public ResponseEntity<BookEntity> updateBook(Long id, CreateBookRequestDto book) {
    Optional<BookEntity> bookEntity = bookRepository.findById(id);
    Optional<AuthorEntity> author = authorRepository.findById(book.getAuthor_id());
    Optional<GenreEntity> genre = genreRepository.findById(book.getGenre_id());

    if ((!bookEntity.isPresent()) || (!author.isPresent()) || (!genre.isPresent())) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    BookEntity bookEntityGet = bookEntity.get();
    bookEntityGet.setAuthor(author.get());
    bookEntityGet.setGenre(genre.get());
    bookEntityGet.setIsbn(book.getIsbn());
    bookEntityGet.setPublished_date(book.getPublished_date());
    bookEntityGet.setTitle(book.getTitle());

    return new ResponseEntity<>(bookEntityGet, HttpStatus.OK);
  }

}
