package com.lab.librarian.service;

import com.lab.librarian.models.Country;
import com.lab.librarian.models.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(CountryDto countryDto);

    Optional<Country> edit(Long id, CountryDto countryDto);

    void deleteById(Long id);

}
