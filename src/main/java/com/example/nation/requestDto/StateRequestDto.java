package com.example.nation.requestDto;


import com.example.nation.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateRequestDto {
    @NotNull
    private Integer stateCode;
    @NotBlank
    private String stateName;

    public static StateRequestDto deserialize(StateEntity stateEntity) {
        return new StateRequestDto() {{
            setStateCode(stateEntity.getStateCode());
            setStateName(stateEntity.getStateName());
        }};
    }
        public  StateEntity serialize(){
            return new StateEntity(){{
                setStateCode(getStateCode());
                setStateName(getStateName());
            }};
        }


    }

