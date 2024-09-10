package com.example.artemis.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateBookRequestDto {
  @JsonProperty("title")
  private String title;

  @JsonProperty("isbn")
  private String isbn;

  @JsonProperty("author_id")
  private Long author_id;
  
  @JsonProperty("genre_id")
  private Long genre_id;

  @JsonProperty("published_date")
  private LocalDate published_date;
}
