package com.dev.santander.application;

import com.dev.santander.domain.model.Champion;
import com.dev.santander.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champion> findAll(){
        return repository.findAll();
    }
}
