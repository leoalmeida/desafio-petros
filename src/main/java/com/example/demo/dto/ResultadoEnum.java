package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResultadoEnum {
    EMPATE(0, "Empate"),
    JOGADOR_1_VENCE(1, "Jogador 1 vence"),
    JOGADOR_2_VENCE(2, "Jogador 2 vence");

    private final int code;
    private final String description;

    ResultadoEnum(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @JsonValue
    public String toJson() {
        return description;
    }
}
