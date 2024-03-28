package com.dev.santander;

import com.dev.santander.application.AskChampionUseCase;
import com.dev.santander.application.ListChampionsUseCase;
import com.dev.santander.domain.ports.ChampionsRepository;
import com.dev.santander.domain.ports.GenerativeAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class DevApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevApplication.class, args);
    }
    @Bean
    public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
        return new ListChampionsUseCase(repository);
    }
    @Bean
    public AskChampionUseCase provideAskChampionUseCase(ChampionsRepository repository, GenerativeAiService genAiService) {

        return new AskChampionUseCase(repository, genAiService);
    }
}
