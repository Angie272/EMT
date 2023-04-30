package com.example.emtlab.service;
import com.example.emtlab.model.Book;
import com.example.emtlab.model.dto.BookDto;
import java.util.List;
import java.util.Optional;
public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> update(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);
}