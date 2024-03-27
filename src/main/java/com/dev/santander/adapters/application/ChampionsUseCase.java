package com.dev.santander.adapters.application;

import com.dev.santander.domain.model.Champions;
import com.dev.santander.domain.ports.ChampionsRepository;

import java.util.List;

public record ChampionsUseCase(
        ChampionsRepository repository
) {
    public List<Champions> findAll(){
        return repository.findAll();
    }
}
