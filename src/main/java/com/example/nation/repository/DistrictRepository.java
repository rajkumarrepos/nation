package com.example.nation.repository;

import com.example.nation.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity,String> {
    Optional<DistrictEntity> findByDistrictCode(Integer districtCode);
}
