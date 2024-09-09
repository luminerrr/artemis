package com.example.artemis.service.impl;

import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.repository.AuthorRepository;
import com.example.artemis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<List<AuthorEntity>> getAllAuthor() {

        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<AuthorEntity> getAuthorById(Long id) {
        var result = authorRepository.findById(id);
        if(result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    public ResponseEntity<String> deleteAuthor(Long id) {
        if(authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
            return new ResponseEntity<>("Success delete author", HttpStatus.OK);
        }

        return new ResponseEntity<>("Failed delete author", HttpStatus.OK);
    }

    public ResponseEntity<AuthorEntity> saveAuthor(AuthorEntity author) {
        AuthorEntity res = authorRepository.save(author);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    public ResponseEntity<AuthorEntity> updateAuthor(Long id) {
        return null;
    }

    public ResponseEntity<AuthorEntity> updateAuthor(Long id, AuthorEntity author) {
        Optional<AuthorEntity> authorByIdOpt = authorRepository.findById(id);

        if (!authorByIdOpt.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        AuthorEntity authorByIdEntity = authorByIdOpt.get();
        authorByIdEntity.setName(author.getName());
        authorRepository.save(authorByIdEntity);

        return new ResponseEntity<>(authorByIdEntity, HttpStatus.OK);
    }

}
