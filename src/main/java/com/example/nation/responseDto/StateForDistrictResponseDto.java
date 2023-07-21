package com.example.nation.responseDto;
import com.example.nation.entity.StateEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class StateForDistrictResponseDto {
    private Integer stateCode;
    private String stateName;



    public static StateForDistrictResponseDto deserialize(StateEntity stateEntity) {
        StateForDistrictResponseDto stateForDistrictResponseDto= new StateForDistrictResponseDto();
        stateForDistrictResponseDto. setStateCode(stateEntity.getStateCode());
        stateForDistrictResponseDto. setStateName(stateEntity.getStateName());

     return stateForDistrictResponseDto;
    }
}
