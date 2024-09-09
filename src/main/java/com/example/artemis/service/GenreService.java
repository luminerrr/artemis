package com.example.artemis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.artemis.entity.GenreEntity;

@Component
public interface GenreService {
  
  ResponseEntity <List<GenreEntity>> getAllGenres();
  ResponseEntity<GenreEntity> getGenreById(Long id);
  ResponseEntity<String> deleteGenre(Long id);
  ResponseEntity<GenreEntity> saveGenre(GenreEntity genre);
  ResponseEntity<GenreEntity> updateGenre(Long id,GenreEntity genre);
}
