package com.example.emtlab.service.impl;
import com.example.emtlab.model.Author;
import com.example.emtlab.model.Book;
import com.example.emtlab.model.dto.BookDto;
import com.example.emtlab.model.exceptions.AuthorNotFoundException;
import com.example.emtlab.model.exceptions.BookNotFoundException;
import com.example.emtlab.model.exceptions.InvalidArgumentsException;
import com.example.emtlab.model.exceptions.NoMoreAvailableBookCopiesException;
import com.example.emtlab.repository.BookRepository;
import com.example.emtlab.service.AuthorService;
import com.example.emtlab.service.BookService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        if (bookDto.getName() == null || bookDto.getName().isEmpty())
            throw new InvalidArgumentsException();
        Author author = authorService.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());



        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Author author = authorService.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book =findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());



        return Optional.of(bookRepository.save(book));
    }
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            return Optional.of(bookRepository.save(book));
        }
        throw new NoMoreAvailableBookCopiesException(id);
    }
}

