package com.example.artemis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.artemis.entity.GenreEntity;
import com.example.artemis.repository.GenreRepository;
import com.example.artemis.service.GenreService;

@Service
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

  public ResponseEntity<String> deleteGenre(Long id) {
    if(genreRepository.findById(id).isPresent()) {
      genreRepository.deleteById(id);
      return new ResponseEntity<>("Success delete", HttpStatus.OK);
    }
    
    return new ResponseEntity<>("Failed delete", HttpStatus.NOT_FOUND);
  }

  public ResponseEntity<GenreEntity> saveGenre(GenreEntity genre) {
    GenreEntity res = genreRepository.save(genre);

    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  public ResponseEntity<GenreEntity> updateGenre(Long id, GenreEntity genre) {
    Optional<GenreEntity> genreByIdOpt = genreRepository.findById(id);

    if (!genreByIdOpt.isPresent()) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    GenreEntity genreByIdEntity = genreByIdOpt.get();
    genreByIdEntity.setName(genre.getName());
    genreRepository.save(genreByIdEntity);

    return new ResponseEntity<>(genreByIdEntity, HttpStatus.OK);
  }
  
}
