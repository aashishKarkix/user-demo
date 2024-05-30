package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public List<BookDTO> getAllBooks() {
    return bookService.findAll().stream().map(BookDTO::fromEntity)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
    Book book = bookService.findById(id);
    return ResponseEntity.ok(BookDTO.fromEntity(book));
  }

  @PostMapping
  public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
    Book book = BookDTO.toEntity(bookDTO);
    Book savedBook = bookService.saveBook(book);
    return ResponseEntity.ok(BookDTO.fromEntity(savedBook));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,
      @RequestBody BookDTO bookDTO) {
    Book book = BookDTO.toEntity(bookDTO);
    Book updatedBook = bookService.update(id, book);
    return ResponseEntity.ok(BookDTO.fromEntity(updatedBook));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
