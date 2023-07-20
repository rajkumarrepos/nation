package com.example.nation.responseDto;
import com.example.nation.entity.StateEntity;
import com.example.nation.requestDto.StateRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateResponseDto {
    private Integer stateCode;
    private String stateName;

    public static StateResponseDto deserialize(StateEntity stateEntity) {
        StateResponseDto stateResponseDto= new StateResponseDto();
        stateResponseDto. setStateCode(stateEntity.getStateCode());
        stateResponseDto. setStateName(stateEntity.getStateName());
     return stateResponseDto;
    }
}
