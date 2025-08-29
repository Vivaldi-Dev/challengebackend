package com.challengebackend.challengebackend.mapper;

import com.challengebackend.challengebackend.dto.CountryDTO;
import com.challengebackend.challengebackend.entity.Country;

public class CountryMapper {
    public static CountryDTO toDTO(Country country) {
        return  CountryDTO.builder()
                .id(country.getId())
                .nome(country.getNome())
                .capital(country.getCapital())
                .regiao(country.getRegiao())
                .subRegiao(country.getSubRegiao())
                .area(country.getArea())
                .build();
    }

    public static Country toEntity(CountryDTO dto) {
        return  Country.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .capital(dto.getCapital())
                .regiao(dto.getRegiao())
                .subRegiao(dto.getSubRegiao())
                .area(dto.getArea())
                .build();
    }
}
