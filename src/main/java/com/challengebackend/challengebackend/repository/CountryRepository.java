package com.challengebackend.challengebackend.repository;

import com.challengebackend.challengebackend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByNomeIgnoreCase(String nome);

}