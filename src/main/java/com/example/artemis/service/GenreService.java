package com.example.artemis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.artemis.entity.GenreEntity;

public interface GenreService {
  
  ResponseEntity <List<GenreEntity>> getAllGenres();
  ResponseEntity<GenreEntity> getGenreById(Long id);
  ResponseEntity<String> deleteGenre(Long id);

  ResponseEntity<GenreEntity> saveGenre(GenreEntity genre);
  GenreEntity addGenre(GenreEntity genre);
  GenreEntity updaGenre(GenreEntity genre);
}
