package com.dev.santander.domain.ports;

import com.dev.santander.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {

    List<Champions> findAll();

    Optional<Champions> findById(long id);
}
