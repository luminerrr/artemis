package com.example.artemis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GenreDto {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;
}
