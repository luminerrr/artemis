package com.example.artemis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.artemis.dto.GenreDto;
import com.example.artemis.entity.GenreEntity;
import com.example.artemis.mapper.GenreMapper;
import com.example.artemis.repository.GenreRepository;
import com.example.artemis.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
  @Autowired
  private GenreRepository genreRepository;

  @Autowired
  private GenreMapper genreMapper;

  @Override
  public ResponseEntity<List<GenreDto>> getAllGenres() {
    List<GenreEntity> res = genreRepository.findAll();
    List<GenreDto> dtoRes = res.stream()
      .map(genreMapper::toDto)
      .toList();
    
    return new ResponseEntity<>(dtoRes, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<GenreDto> getGenreById(Long id) {
    var result = genreRepository.findById(id);
    if(result.isPresent()) {
      var genreDto = genreMapper.toDto(result.get());
      return new ResponseEntity<>(genreDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseEntity<String> deleteGenre(Long id) {
    if(genreRepository.findById(id).isPresent()) {
      genreRepository.deleteById(id);
      return new ResponseEntity<>("Success delete", HttpStatus.OK);
    }
    
    return new ResponseEntity<>("Failed delete", HttpStatus.NOT_FOUND);
  }

  @Override
  public ResponseEntity<GenreDto> saveGenre(GenreDto genre) {
    GenreEntity entity = genreMapper.toEntity(genre);
    GenreEntity saved = genreRepository.save(entity);
    GenreDto savedDto = genreMapper.toDto(saved);
    // GenreRepository genreRes = genreMapper.toEntity(genre);
    // GenreDto res = genreRepository.save(genre);

    return new ResponseEntity<>(savedDto, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<GenreDto> updateGenre(Long id, GenreDto genre) {
    Optional<GenreEntity> genreByIdOpt = genreRepository.findById(id);
    if (!genreByIdOpt.isPresent()) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    GenreEntity genreByIdEntity = genreByIdOpt.get();
    genreByIdEntity.setName(genre.getName());
    genreRepository.save(genreByIdEntity);
    GenreDto dtoRes = genreMapper.toDto(genreByIdEntity);

    return new ResponseEntity<>(dtoRes, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Page<GenreDto>> getGenrePages(Pageable pageable) {
    Page<GenreEntity> pageEntity = genreRepository.findAll(pageable);
    Page<GenreDto> pageDto = pageEntity.map(genreMapper::toDto);

    return new ResponseEntity<>(pageDto, HttpStatus.OK);
  }
  
}
