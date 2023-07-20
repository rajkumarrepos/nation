package com.example.nation.repository;

import com.example.nation.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,String> {
    Optional<CountryEntity> findByCountryCode(String countryCode);

}
