package com.dev.santander.application;

import com.dev.santander.domain.exception.ChampionNotFoundException;
import com.dev.santander.domain.model.Champion;
import com.dev.santander.domain.ports.ChampionsRepository;
import com.dev.santander.domain.ports.GenerativeAiService;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiService genAiService) {

    public String askChampion(Long championId, String question) {

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String Context = champion.generateContextByQuestion(question);

        String objective = """
                Atua como um assistente com a habilidade de se comportar como os campeões
                do League of Legends(LOL).
                Responda perguntas incorporadas a personalidade e estilo de um determinado campeão.
                Segue a pergunta, o mome do campeão e sua respectiva lore(história):
                """;

        return genAiService.generateContent(objective, Context);

    }
}
