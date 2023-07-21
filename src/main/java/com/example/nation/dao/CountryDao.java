package com.example.nation.dao;

import com.example.nation.entity.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface CountryDao {
    Optional<CountryEntity> isCodeExists(String countryCode);
    void save(CountryEntity countryEntity);
    List<CountryEntity> getAll();

    void delete(String id);
}
