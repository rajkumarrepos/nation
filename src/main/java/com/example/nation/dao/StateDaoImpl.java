package com.example.nation.dao;

import com.example.nation.entity.StateEntity;
import com.example.nation.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StateDaoImpl implements StateDao {
    private final StateRepository stateRepository;

    @Override
    public void save(StateEntity stateEntity) {
        stateEntity.setId(stateRepository.save(stateEntity).getId());
    }

    @Override
    public Optional<StateEntity> isStateCodeExists(Integer stateCode) {
        return stateRepository.findByStateCode(stateCode);
    }

    @Override
    public List<StateEntity> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public String deleteByCountryId(String id) {
        stateRepository.deleteAllByCountryEntityId(id);
        return "success";
    }

    @Override
    public List<String> getAllStateIdByCountryId(String id) {
        return stateRepository.getStateIdsByCountryId(id);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        stateRepository.deleteById(id);
    }
}

