package com.example.artemis.repository;

import com.example.artemis.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findById(Long id);

    //Find all authors
    Page<AuthorEntity> findAll(Pageable pageable);
}
