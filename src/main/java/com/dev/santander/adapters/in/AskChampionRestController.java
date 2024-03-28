package com.dev.santander.adapters.in;

import com.dev.santander.application.AskChampionUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Camper", description = "Endpoints dos campeões do LoL.")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionUseCase useCase) {

    //recuperar dado de forma simples
    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampionResponse(@PathVariable Long championId, @RequestBody AskChampionRequest request){
        String answer = useCase.askChampion(championId, request.question());

        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question){ }
    public record AskChampionResponse(String answer){ }
}
