package com.example.emtlab.service.impl;
import com.example.emtlab.model.Author;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.dto.AuthorDto;
import com.example.emtlab.model.exceptions.AuthorNotFoundException;
import com.example.emtlab.model.exceptions.CountryNotFoundException;
import com.example.emtlab.model.exceptions.InvalidArgumentsException;
import com.example.emtlab.repository.AuthorRepository;
import com.example.emtlab.service.AuthorService;
import com.example.emtlab.service.CountryService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        if (authorDto.getName() == null || authorDto.getName().isEmpty() || authorDto.getSurname() == null || authorDto.getSurname().isEmpty())
            throw new InvalidArgumentsException();
        Country country = countryService.findById(authorDto.getCountryId()).orElseThrow(() -> new CountryNotFoundException(authorDto.getCountryId()));
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);


        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> update(Long id, AuthorDto authorDto) {
        Author author = findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        Country country = countryService.findById(authorDto.getCountryId()).orElseThrow(() -> new CountryNotFoundException(authorDto.getCountryId()));
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(country);


        return Optional.of(authorRepository.save(author));
    }
    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}