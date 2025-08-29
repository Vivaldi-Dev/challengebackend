package com.challengebackend.challengebackend.service.impl;

import com.challengebackend.challengebackend.dto.CountryDTO;
import com.challengebackend.challengebackend.entity.Country;
import com.challengebackend.challengebackend.mapper.CountryMapper;
import com.challengebackend.challengebackend.repository.CountryRepository;
import com.challengebackend.challengebackend.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public CountryDTO createCountry(CountryDTO dto) {
        boolean exists = countryRepository.existsByNomeIgnoreCase(dto.getNome());
        if (exists) {
            throw new IllegalArgumentException("Country with the same name already exists");
        }
        Country country = CountryMapper.toEntity(dto);
        Country saved = countryRepository.save(country);
        return CountryMapper.toDTO(saved);
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(CountryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDTO> getAllCountriesSorted(String property) {
        return countryRepository.findAll(Sort.by(property))
                .stream()
                .map(CountryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CountryDTO> getCountryById(Long id) {
        return countryRepository.findById(id).map(CountryMapper::toDTO);
    }

    @Override
    public Optional<CountryDTO> updateCountry(Long id, CountryDTO dto) {
        return countryRepository.findById(id).map(existing -> {
            existing.setNome(dto.getNome());
            existing.setCapital(dto.getCapital());
            existing.setRegiao(dto.getRegiao());
            existing.setSubRegiao(dto.getSubRegiao());
            existing.setArea(dto.getArea());
            return CountryMapper.toDTO(countryRepository.save(existing));
        });
    }

    @Override
    public boolean deleteCountry(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }




}
