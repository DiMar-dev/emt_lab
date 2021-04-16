package com.lab.librarian.service.implementations;


import com.lab.librarian.models.Country;
import com.lab.librarian.models.dto.CountryDto;
import com.lab.librarian.models.exceptions.CountryNotFound;
import com.lab.librarian.repository.CountryRepository;
import com.lab.librarian.service.CountryService;
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
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        return Optional.of(this.countryRepository
                                .save(new Country(countryDto.getName(),
                                                    countryDto.getContinet())));
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country=this.countryRepository.findById(id).orElseThrow(() -> new CountryNotFound(id));

        country.setName(countryDto.getName());
        country.setContinet(countryDto.getContinet());

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
