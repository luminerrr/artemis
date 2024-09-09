package com.example.artemis.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.artemis.entity.GenreEntity;
import com.example.artemis.service.GenreService;
import com.example.artemis.service.impl.GenreServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  public ResponseEntity<List<GenreEntity>> getAllGenres() {
    return genreService.getAllGenres();
  }

  // GET /id
  @GetMapping("/{id}")
  public ResponseEntity<GenreEntity> getGenreById(@PathVariable Long id) {
      return genreService.getGenreById(id);
  }
  

  // POST /
  @PostMapping
  public ResponseEntity<GenreEntity> createGenre(@RequestBody GenreEntity entity) {
      return genreService.saveGenre(entity);
  }
  
  // PUT /id
  @PutMapping("/{id}")
  public ResponseEntity<GenreEntity> updateGenre(@PathVariable Long id, @RequestBody GenreEntity entity) { 
      return genreService.updateGenre(id, entity);
  }

  // DELETE /id
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
    return genreService.deleteGenre(id);
  }
}
