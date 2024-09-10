package com.example.artemis.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.artemis.dto.CreateGenreRequestDto;
import com.example.artemis.dto.GenreDto;
import com.example.artemis.entity.GenreEntity;
import com.example.artemis.service.GenreService;
import com.example.artemis.service.impl.GenreServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/genres")
public class GenreController {

  @Autowired()
  private GenreService genreService;

  // GET /
  @GetMapping()
  public ResponseEntity<List<GenreDto>> getAllGenres() {
    return genreService.getAllGenres();
  }

  // GET /id
  @GetMapping("/{id}")
  public ResponseEntity<GenreDto> getGenreById(@PathVariable Long id) {
      return genreService.getGenreById(id);
  }
  

  // POST /
  @PostMapping
  public ResponseEntity<GenreDto> createGenre(@RequestBody CreateGenreRequestDto dto) {
    return genreService.saveGenre(dto);
  }
  
  // PUT /id
  @PutMapping("/{id}")
  public ResponseEntity<GenreDto> updateGenre(@PathVariable Long id, @RequestBody GenreDto entity) { 
      return genreService.updateGenre(id, entity);
  }

  // DELETE /id
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
    return genreService.deleteGenre(id);
  }

  @GetMapping("/page")
  public ResponseEntity<Page<GenreDto>> getGenrePages(Pageable pageable) {
      return genreService.getGenrePages(pageable);
  }
  
}
