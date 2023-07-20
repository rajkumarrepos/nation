package com.example.nation.repository;

import com.example.nation.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<StateEntity,String> {
    Optional<StateEntity> findByStateCode(Integer stateCode);
}
