package com.dev.santander.application;

import com.dev.santander.domain.exception.ChampionNotFoundException;
import com.dev.santander.domain.model.Champion;
import com.dev.santander.domain.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId, String question) {

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        // TODO: Evoluir a lógica de negócio para considerar a integração com IAs Generativas.

        return championContext;
    }
}
