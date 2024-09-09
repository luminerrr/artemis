package com.example.artemis.repository;

import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByTitle(String title);

    Optional<BookEntity> findByTitleIgnoreCase(String title);

}
