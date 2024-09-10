package com.example.artemis.mapper;

import org.springframework.stereotype.Component;

import com.example.artemis.dto.GenreDto;
import com.example.artemis.entity.GenreEntity;

@Component
public class GenreMapper {
  public GenreDto toDto(GenreEntity entity) {
    if (entity == null) {
      return null;
    }
    GenreDto dto = new GenreDto();
    dto.setId(entity.getId());
    dto.setName(entity.getName());

    return dto;
  }

  public GenreEntity toEntity(GenreDto dto) {
    if(dto == null) return null;
    
    GenreEntity entity = new GenreEntity();
    entity.setId(dto.getId());
    entity.setName(dto.getName());

    return entity;
  }
}
