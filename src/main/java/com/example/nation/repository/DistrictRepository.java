package com.example.nation.repository;

import com.example.nation.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity,String> {
    Optional<DistrictEntity> findByDistrictCode(Integer districtCode);

    @Modifying
    @Query("delete from DistrictEntity t where t.stateEntity.id in (?1)")
    void deleteAllByStateEntityIdIn(List<String> id);
}
