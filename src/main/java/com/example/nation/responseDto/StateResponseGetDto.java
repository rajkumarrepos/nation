package com.example.nation.responseDto;
import com.example.nation.entity.StateEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StateResponseGetDto {
    private Integer stateCode;
    private String stateName;
    private List<DistrictResponseDto> districtResponseDtos;

    public static StateResponseGetDto deserialize(StateEntity stateEntity) {
        StateResponseGetDto stateResponseDto= new StateResponseGetDto();
        stateResponseDto. setStateCode(stateEntity.getStateCode());
        stateResponseDto. setStateName(stateEntity.getStateName());
        List<DistrictResponseDto> districtResponseDtoFinal = new ArrayList<>();
        stateEntity.getDistrictEntity().stream().forEach(districtEntity -> {
        DistrictResponseDto districtResponseDto=DistrictResponseDto.deserialize(districtEntity);
        districtResponseDtoFinal.add(districtResponseDto);
        });
         stateResponseDto.setDistrictResponseDtos(districtResponseDtoFinal);
     return stateResponseDto;
    }
}
