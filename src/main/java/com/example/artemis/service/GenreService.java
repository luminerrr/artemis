package com.example.artemis.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.artemis.dto.GenreDto;
import com.example.artemis.entity.GenreEntity;

@Component
public interface GenreService {
  
  ResponseEntity <List<GenreDto>> getAllGenres();
  ResponseEntity<GenreDto> getGenreById(Long id);
  ResponseEntity<String> deleteGenre(Long id);
  ResponseEntity<GenreDto> saveGenre(GenreDto genre);
  ResponseEntity<GenreDto> updateGenre(Long id,GenreDto genre);
  ResponseEntity<Page<GenreDto>> getGenrePages(Pageable pageable);
}
