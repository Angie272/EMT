package com.example.emtlab.service.impl;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.dto.CountryDto;
import com.example.emtlab.model.exceptions.CountryNotFoundException;
import com.example.emtlab.model.exceptions.InvalidArgumentsException;
import com.example.emtlab.repository.CountryRepository;
import com.example.emtlab.service.CountryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        if (countryDto.getName() == null || countryDto.getContinent() == null || countryDto.getName().isEmpty() || countryDto.getContinent().isEmpty()) {
            throw new InvalidArgumentsException();
        }

        Country country = new Country(countryDto.getName(), countryDto.getContinent());
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, CountryDto countryDto) {
        Country country = findById(id).orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        return Optional.of(countryRepository.save(country));
    }
    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}