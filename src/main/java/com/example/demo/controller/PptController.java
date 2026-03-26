package com.example.demo.controller;

import com.example.demo.dto.PptDtoRequest;
import com.example.demo.dto.PptDtoResponse;
import com.example.demo.service.PptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/PPT")
public class PptController {

    private final PptService pptService;

    public PptController(final PptService pptService) {
        this.pptService = pptService;
    }

    /**
     * A aplicação deve expor um endpoint POST que receba as jogadas dos dois
     * jogadores e retorne o resultado da partida. As jogadas devem ser
     * informadas como strings: "PEDRA", "PAPEL" ou
     * "TESOURA" (case-insensitive). A resposta deve indicar: As jogadas de cada
     * jogador O resultado da partida: "Empate" "Jogador 1 vence" "Jogador 2
     * vence"
     */
    @PostMapping
    public ResponseEntity<PptDtoResponse> realizarJogada(@RequestBody @Valid final PptDtoRequest request) {

        PptDtoResponse response = pptService.realizarJogada(request);
        return ResponseEntity.ok(response);
    }
}
