package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PptDtoRequest {

    private Long id;

    @NotNull(message = "jogador1 e obrigatorio")
    private JogadaEnum jogador1;

    @NotNull(message = "jogador2 e obrigatorio")
    private JogadaEnum jogador2;
}
