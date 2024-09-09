package com.example.artemis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.artemis.entity.GenreEntity;
import com.example.artemis.repository.GenreRepository;
import com.example.artemis.service.GenreService;

public class GenreServiceImpl implements GenreService {
  @Autowired
  private GenreRepository genreRepository;

  public ResponseEntity<List<GenreEntity>> getAllGenres() {
    return new ResponseEntity<>(genreRepository.findAll(), HttpStatus.OK);
  }

  public ResponseEntity<GenreEntity> getGenreById(Long id) {
    var result = genreRepository.findById(id);
    if(result.isPresent()) {
      return new ResponseEntity<>(result.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  public void deleteGenre(Long id) {
    genreRepository.deleteById(id);
  }
  
}
