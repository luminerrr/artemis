package com.example.artemis.repository;

import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findById(Long id);

    Optional<BookEntity> findByTitle(String title);

    Optional<BookEntity> findByTitleIgnoreCase(String title);

    //Find all books
    Page<BookEntity> findAll(Pageable pageable);

    // @Query(nativeQuery = true,  value = "SELECT * FROM books WHERE title LIKE :title")
    // Page<BookEntity> findBooksByTitleLike

}
