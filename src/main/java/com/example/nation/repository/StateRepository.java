package com.example.nation.repository;

import com.example.nation.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<StateEntity,String> {
    Optional<StateEntity> findByStateCode(Integer stateCode);

    @Modifying
    @Query("delete from StateEntity t where t.countryEntity.id = ?1")
    void deleteAllByCountryEntityId(String id);

    @Modifying
    @Query("delete from StateEntity t where t.stateCode = ?1")
    void deleteAllByStateCode(Integer code);

    @Query("select s.id from StateEntity s where s.countryEntity.id = ?1")
    List<String> getStateIdsByCountryId(String id);
}
