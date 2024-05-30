package com.example.demo.dto;

import com.example.demo.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
  private Long id;
  private String title;
  private String author;
  private String isbn;

  public static BookDTO fromEntity(Book book) {
    BookDTO dto = new BookDTO();
    dto.setId(book.getId());
    dto.setTitle(book.getTitle());
    dto.setAuthor(book.getAuthor());
    dto.setIsbn(book.getIsbn());
    return dto;
  }

  public static Book toEntity(BookDTO dto) {
    Book book = new Book();
    book.setId(dto.getId());
    book.setTitle(dto.getTitle());
    book.setAuthor(dto.getAuthor());
    book.setIsbn(dto.getIsbn());
    return book;
  }
}
