package com.example.nation.dao;

import com.example.nation.entity.StateEntity;

import java.util.List;
import java.util.Optional;

public interface StateDao {
    void save(StateEntity stateEntity);
    Optional<StateEntity> isStateCodeExists(Integer stateCode);
    List<StateEntity> getAll();

     String deleteByCountryId(String id);

     List<String> getAllStateIdByCountryId(String id);

     void deleteById(String id);
}
