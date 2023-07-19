package com.example.nation.requestDto;

import com.example.nation.entity.DistrictEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictRequestDto {
    @NotNull
    private Integer districtCode;
    @NotBlank
    private String districtName;

    public static DistrictRequestDto deserialize(DistrictEntity districtEntity) {
        return new DistrictRequestDto() {{
            setDistrictCode(districtEntity.getDistrictCode());
            setDistrictName(districtEntity.getDistrictName());
        }};
    }
    public  DistrictEntity serialize(){
        return new DistrictEntity(){{
            setDistrictCode(getDistrictCode());
            setDistrictName(getDistrictName());
        }};
    }


}
