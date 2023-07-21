package com.example.nation.dao;

import com.example.nation.entity.StateEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StateDao {
    void save(StateEntity stateEntity);
    Optional<StateEntity> isStateCodeExists(Integer stateCode);
    Page<StateEntity> getAll(Pageable pageable);

     String deleteByCountryId(String id);

     List<String> getAllStateIdByCountryId(String id);

     void deleteById(String id);
}
