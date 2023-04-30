package com.example.emtlab.bootstrap;
import com.example.emtlab.model.Author;
import com.example.emtlab.model.Category;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.dto.AuthorDto;
import com.example.emtlab.model.dto.BookDto;
import com.example.emtlab.model.dto.CountryDto;
import com.example.emtlab.service.AuthorService;
import com.example.emtlab.service.BookService;
import com.example.emtlab.service.CountryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class DataInitializer {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData(){
      this.countryService.save(new CountryDto("United Kingdom", "northwestern Europe"));
      this.countryService.save(new CountryDto("California", "North America"));
        List<Country> countries = this.countryService.findAll();

      this.authorService.save(new AuthorDto("William","Shakespeare",countries.get(0).getId()));
      this.authorService.save(new AuthorDto("Jack","London",countries.get(1).getId()));
        List<Author> authors = this.authorService.findAll();

      this.bookService.save(new BookDto("Romeo and Juliet",Category.DRAMA,authors.get(0).getId(),3));
      this.bookService.save(new BookDto("The Call of the Wild",Category.CLASSICS,authors.get(1).getId(),8));
    }
}