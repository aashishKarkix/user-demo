package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  public Book findById(Long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
  }

  public Book update(Long id, Book bookDetails) {
    Book book = findById(id);
    book.setTitle(bookDetails.getTitle());
    book.setAuthor(bookDetails.getAuthor());
    book.setIsbn(bookDetails.getIsbn());
    return bookRepository.save(book);
  }

  public void delete(Long id) {
    Book book = findById(id);
    bookRepository.delete(book);
  }
}
