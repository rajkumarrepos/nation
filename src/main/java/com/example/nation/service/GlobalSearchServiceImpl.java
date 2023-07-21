package com.example.nation.service;

import com.example.nation.entity.StateEntity;
import com.example.nation.repository.StateCriteriaBuilderRepo;
import com.example.nation.responseDto.StateResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class GlobalSearchServiceImpl implements GlobalSearchService{
    @Autowired
    private StateCriteriaBuilderRepo stateCriteriaBuilderRepo;
   public  List<StateResponseDto> globalSearchService(String stateName){
      List<StateEntity> stateEntities=stateCriteriaBuilderRepo.findTheStateByName(stateName);
     List<StateResponseDto> stateResponseDtos=new ArrayList<>();
       stateEntities.stream().forEach(stateEntity->{
          StateResponseDto stateResponseDto=new StateResponseDto();
          BeanUtils.copyProperties(stateEntity,stateResponseDto);
          stateResponseDtos.add(stateResponseDto);

      });
      return stateResponseDtos;

    }


}



