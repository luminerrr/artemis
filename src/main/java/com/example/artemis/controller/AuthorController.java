package com.example.artemis.controller;

import com.example.artemis.entity.AuthorEntity;
import com.example.artemis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired()
    private AuthorService authorService;

    // GET /
    @GetMapping()
    public ResponseEntity<List<AuthorEntity>> getAllAuthor() { return authorService.getAllAuthor(); }

    // GET /id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getGenreById(@PathVariable Long id) { return authorService.getAuthorById(id); }

    // POST /
    @PostMapping
    public ResponseEntity<AuthorEntity> createAuthor(@RequestBody AuthorEntity entity) {
        return authorService.saveAuthor(entity);
    }

    // PUT /id
    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> updateAuthor(@PathVariable Long id, @RequestBody AuthorEntity entity) {
        return authorService.updateAuthor(id, entity);
    }

    // DELETE /id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) { return authorService.deleteAuthor(id); }
}
