package com.challengebackend.challengebackend.service;

import com.challengebackend.challengebackend.dto.CountryDTO;

import java.util.List;
import java.util.Optional;


public interface CountryService {

    CountryDTO createCountry(CountryDTO dto);

    List<CountryDTO> getAllCountries();

    List<CountryDTO> getAllCountriesSorted(String property);

    Optional<CountryDTO> getCountryById(Long id);

    Optional<CountryDTO> updateCountry(Long id, CountryDTO dto);

    boolean deleteCountry(Long id);
}
