package com.example.nation.responseDto;
import com.example.nation.entity.StateEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StateGetAndUpResponseDto {
    private Integer stateCode;
    private String stateName;


    public static StateGetAndUpResponseDto deserialize(StateEntity stateEntity) {
        StateGetAndUpResponseDto stateResponseDto= new StateGetAndUpResponseDto();
        stateResponseDto. setStateCode(stateEntity.getStateCode());
        stateResponseDto. setStateName(stateEntity.getStateName());
     return stateResponseDto;
    }
}
