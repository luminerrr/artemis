package com.example.artemis.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.artemis.entity.GenreEntity;
import com.example.artemis.service.GenreService;
import com.example.artemis.service.impl.GenreServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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


  // POST /

  // PUT /id
}
