package com.dev.santander.domain.exception;

public class ChampionNotFoundException extends RuntimeException{
    public ChampionNotFoundException(Long champioId) {
        super("Champion %d not found.".formatted(champioId));
    }
}
