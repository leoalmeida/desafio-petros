package com.example.demo.service.impl;

import com.example.demo.dto.JogadaEnum;
import com.example.demo.dto.PptDtoRequest;
import com.example.demo.dto.PptDtoResponse;
import com.example.demo.dto.ResultadoEnum;
import com.example.demo.service.PptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PptServiceImpl implements PptService {

    @Override
    public PptDtoResponse realizarJogada(final PptDtoRequest request) {
        PptDtoResponse response = new PptDtoResponse();
        response.setDataHora(java.time.LocalDateTime.now());
        if (request.getJogador1().equals(request.getJogador2())) {
            response.setResultado(ResultadoEnum.EMPATE);
        } else if ((request.getJogador1().equals(JogadaEnum.PEDRA)
                        && request.getJogador2().equals(JogadaEnum.TESOURA))
                || (request.getJogador1().equals(JogadaEnum.PAPEL)
                        && request.getJogador2().equals(JogadaEnum.PEDRA))
                || (request.getJogador1().equals(JogadaEnum.TESOURA)
                        && request.getJogador2().equals(JogadaEnum.PAPEL))) {
            response.setResultado(ResultadoEnum.JOGADOR_1_VENCE);
        } else {
            response.setResultado(ResultadoEnum.JOGADOR_2_VENCE);
        }
        return response;
    }
}
