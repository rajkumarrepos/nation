package com.example.nation.dao;

import com.example.nation.entity.DistrictEntity;
import com.example.nation.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class DistrictDaoImpl implements DistrictDao {
    private final DistrictRepository districtRepository;
    @Override
    public void save(DistrictEntity districtEntity){
        districtRepository.save(districtEntity);
    }

    @Override
    public void saveAll(List<DistrictEntity> districtEntity) {
        districtRepository.saveAll(districtEntity);
    }

    @Override
    public Optional<DistrictEntity> isExistsCode(Integer districtCode){
        return districtRepository.findByDistrictCode(districtCode);
    }
    @Override
    public List<DistrictEntity> getAll(){
        return districtRepository.findAll();
    }
    @Override
    public void delete(String id){
        districtRepository.deleteByDistrictId(id);
    }

    @Override
    public String deleteByStateId(List<String> id) {
        districtRepository.deleteAllByStateEntityIdIn(id);
        return " ";
    }
}
