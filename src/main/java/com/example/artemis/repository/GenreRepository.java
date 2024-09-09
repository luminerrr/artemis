package com.example.artemis.repository;

import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.entity.BookEntity;
import com.example.artemis.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findByName(String name);

    Optional<GenreEntity> findByNameIgnoreCase(String name);

    //Find all genre
    Page<GenreEntity> findAll(Pageable pageable);
}
