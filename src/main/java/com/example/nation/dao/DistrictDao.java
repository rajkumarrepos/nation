package com.example.nation.dao;

import com.example.nation.entity.DistrictEntity;

import java.util.List;
import java.util.Optional;

public interface DistrictDao {
    void save(DistrictEntity districtEntity);

    void saveAll(List<DistrictEntity> districtEntitys);
    Optional<DistrictEntity> isExistsCode(Integer districtCode);
    List<DistrictEntity> getAll();
    void delete(String id);

    String deleteByStateId(List<String> id);
}
