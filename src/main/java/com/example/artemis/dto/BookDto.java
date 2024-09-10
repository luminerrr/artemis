package com.example.artemis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BookDto {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("author")
  private AuthorDto author;
}
