package com.example.demo.dto;

import java.time.LocalDateTime;
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
public class PptDtoResponse {
    private Long id;
    private LocalDateTime dataHora;
    private JogadaEnum jogador1;
    private JogadaEnum jogador2;
    private ResultadoEnum resultado;
}
