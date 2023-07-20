package com.example.nation.dao;

import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.DistrictEntity;
import com.example.nation.entity.StateEntity;
import com.example.nation.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StateDaoImpl implements StateDao {
    private final StateRepository stateRepository;
    @Override
    public void save(StateEntity stateEntity){
        stateRepository.save(stateEntity);
    }
    @Override
    public Optional<StateEntity>  isStateCodeExists(Integer stateCode){
        return  stateRepository.findByStateCode(stateCode);
    }
    @Override
    public List<StateEntity> getAll(){
        return stateRepository.findAll();
    }
}

