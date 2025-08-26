package com.example.library.web;

import com.example.library.model.Book;
import com.example.library.repo.BookRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Book> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> one(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String q) {
        return repo.search(q);
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        Book saved = repo.save(book);
        return ResponseEntity.created(URI.create("/api/books/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody Book payload) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(payload.getTitle());
            existing.setAuthor(payload.getAuthor());
            existing.setStatus(payload.getStatus());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
