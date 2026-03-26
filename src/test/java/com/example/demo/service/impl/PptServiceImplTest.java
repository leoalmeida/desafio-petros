package com.example.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.demo.dto.JogadaEnum;
import com.example.demo.dto.PptDtoRequest;
import com.example.demo.dto.PptDtoResponse;
import com.example.demo.dto.ResultadoEnum;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PptServiceImplTest {

    private final PptServiceImpl pptService = new PptServiceImpl();

    @ParameterizedTest
    @MethodSource("jogadas")
    void deveAvaliarResultadoDaPartida(
            final JogadaEnum jogador1, final JogadaEnum jogador2, final ResultadoEnum resultadoEsperado) {
        PptDtoRequest request = PptDtoRequest.builder().jogador1(jogador1).jogador2(jogador2).build();

        PptDtoResponse response = pptService.realizarJogada(request);

        assertEquals(jogador1, response.getJogador1());
        assertEquals(jogador2, response.getJogador2());
        assertEquals(resultadoEsperado, response.getResultado());
        assertNotNull(response.getDataHora());
    }

    private static Stream<Arguments> jogadas() {
        return Stream.of(
                Arguments.of(JogadaEnum.PEDRA, JogadaEnum.PEDRA, ResultadoEnum.EMPATE),
                Arguments.of(JogadaEnum.PAPEL, JogadaEnum.PAPEL, ResultadoEnum.EMPATE),
                Arguments.of(JogadaEnum.TESOURA, JogadaEnum.TESOURA, ResultadoEnum.EMPATE),
                Arguments.of(JogadaEnum.PEDRA, JogadaEnum.TESOURA, ResultadoEnum.JOGADOR_1_VENCE),
                Arguments.of(JogadaEnum.PAPEL, JogadaEnum.PEDRA, ResultadoEnum.JOGADOR_1_VENCE),
                Arguments.of(JogadaEnum.TESOURA, JogadaEnum.PAPEL, ResultadoEnum.JOGADOR_1_VENCE),
                Arguments.of(JogadaEnum.TESOURA, JogadaEnum.PEDRA, ResultadoEnum.JOGADOR_2_VENCE),
                Arguments.of(JogadaEnum.PEDRA, JogadaEnum.PAPEL, ResultadoEnum.JOGADOR_2_VENCE),
                Arguments.of(JogadaEnum.PAPEL, JogadaEnum.TESOURA, ResultadoEnum.JOGADOR_2_VENCE));
    }
}