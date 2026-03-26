package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;

public enum JogadaEnum {
    PEDRA,
    PAPEL,
    TESOURA;

    @JsonCreator
    public static JogadaEnum fromValue(final String value) {
        return Arrays.stream(values())
                .filter(jogada -> jogada.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Jogada invalida: " + value));
    }
}
