package com.example.nation.dao;

import com.example.nation.entity.StateEntity;
import com.example.nation.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class StateDaoImpl implements StateDao {
    private final StateRepository stateRepository;
    @Override
    public void save(StateEntity stateEntity){
        stateRepository.save(stateEntity);
    }
}

