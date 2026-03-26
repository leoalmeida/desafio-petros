package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PptService;

import space.lasf.agendamento.dto.AgendamentoDto;


@RestController
@RequestMapping("/api/v1/PPT")
public class PptController {

    @Autowired
    private PptService pptService;

    /**
     * A aplicação deve expor um endpoint POST que receba as jogadas dos dois jogadores e retorne o resultado da partida.
            As jogadas devem ser informadas como strings: "PEDRA", "PAPEL" ou "TESOURA" (case-insensitive).
            A resposta deve indicar:
            As jogadas de cada jogador
            O resultado da partida:
            "Empate"
            "Jogador 1 vence"
            "Jogador 2 vence"
     */
    @PostMapping("/{idJogo}/{jogada1}/{jogada2}") 
    public ResponseEntity<AgendamentoDto> realizarJogada(
            @RequestBody @Valid final AgendamentoDto agendamento, final UriComponentsBuilder uriBuilder) {
        agendamentoService.createAgendamento(agendamento);
        return ResponseEntity.accepted().build();
    }


}
