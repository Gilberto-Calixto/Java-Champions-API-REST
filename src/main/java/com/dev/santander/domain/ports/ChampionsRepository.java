package com.dev.santander.domain.ports;

import com.dev.santander.domain.model.Champion;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {

    List<Champion> findAll();

    Optional<Champion> findById(long id);
}
