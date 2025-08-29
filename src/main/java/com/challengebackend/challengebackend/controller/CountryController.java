package com.challengebackend.challengebackend.controller;

import com.challengebackend.challengebackend.dto.CountryDTO;
import com.challengebackend.challengebackend.exception.ErrorResponse;
import com.challengebackend.challengebackend.service.CountryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@Validated @RequestBody CountryDTO dto) {
        CountryDTO created = countryService.createCountry(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }


    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries(
            @RequestParam(value = "sortBy", required = false) String sortBy) {
        List<CountryDTO> countries;
        if (sortBy != null && !sortBy.isEmpty()) {
            countries = countryService.getAllCountriesSorted(sortBy);
        } else {
            countries = countryService.getAllCountries();
        }
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id,
                                                    @Validated @RequestBody CountryDTO dto) {
        return countryService.updateCountry(id, dto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        boolean deleted = countryService.deleteCountry(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        throw new EntityNotFoundException("Country not found");
    }

}