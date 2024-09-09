package com.example.artemis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.artemis.entity.GenreEntity;

public interface GenreService {
  
  ResponseEntity <List<GenreEntity>> getAllGenres();
  GenreEntity saveGenre(GenreEntity genre);
  ResponseEntity<GenreEntity> getGenreById(Long id);
  void deleteGenre(Long id);
  GenreEntity addGenre(GenreEntity genre);
  GenreEntity updaGenre(GenreEntity genre);
}
