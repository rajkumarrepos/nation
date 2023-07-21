package com.example.nation.requestDto;


import com.example.nation.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StateUpdateRequestDto {

    @NotBlank
    private String stateName;

        public  StateEntity serialize(){
            StateEntity stateEntity= new StateEntity();
                stateEntity. setStateName(getStateName());
            return stateEntity;
        }


    }

