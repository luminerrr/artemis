package com.example.artemis.repository;

import com.example.artemis.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findById(Long id);

    Optional<BookEntity> findByTitle(String title);

    Optional<BookEntity> findByTitleIgnoreCase(String title);

    @Query(
            value = "select b.* from books b " +
                    "join authors a on b.author_id = a.id " +
                    "join genres g on g.id = b.genre_id " +
                    "where b.title like :title or " +
                    "a.name like :author or " +
                    "g.name like :genre ",
            nativeQuery = true
    )
            List<BookEntity> searchBooks(@Param("title") String title, @Param("author") String author, @Param("genre") String genre);

    //Find all books
    Page<BookEntity> findAll(Pageable pageable);

    // @Query(nativeQuery = true,  value = "SELECT * FROM books WHERE title LIKE :title")
    // Page<BookEntity> findBooksByTitleLike

}
