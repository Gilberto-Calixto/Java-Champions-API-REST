package com.dev.santander.adapters.in;

import com.dev.santander.application.ListChampionsUseCase;
import com.dev.santander.domain.model.Champion;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Camper", description = "Endpoints dos campeões do LoL.")
@RestController
//mapeando end point para saber como acessar url da API
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @CrossOrigin
    @GetMapping
    public List<Champion> findAllChampions() {
        return useCase.findAll();
    }
}