package com.example.nation.responseDto;


import com.example.nation.entity.DistrictEntity;
import com.example.nation.requestDto.DistrictRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictResponseDto {
    private Integer districtCode;
    private String districtName;

    public static DistrictResponseDto deserialize(DistrictEntity districtEntity) {
        return new DistrictResponseDto() {{
            setDistrictCode(districtEntity.getDistrictCode());
            setDistrictName(districtEntity.getDistrictName());
        }};
    }
}
