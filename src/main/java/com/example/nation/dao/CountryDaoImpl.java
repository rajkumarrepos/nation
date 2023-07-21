package com.example.nation.dao;

import com.example.nation.entity.CountryEntity;
import com.example.nation.repository.CountryRepository;
import com.example.nation.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CountryDaoImpl implements CountryDao {

    private final CountryRepository countryRepository;
    @Override
    public Optional<CountryEntity> isCodeExists(String countryCode){
      return  countryRepository.findByCountryCode(countryCode);
    }
    @Override
    public void save(CountryEntity countryEntity){
        countryEntity.setId( countryRepository.save(countryEntity).getId());
    }
    @Override
    public List<CountryEntity> getAll(){
       return countryRepository.findAll();
    }

    @Override
    public void delete(String id) {
        countryRepository.deleteAllById(id);
    }
}
