package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PptDtoRequest;
import com.example.demo.dto.PptDtoResponse;
import com.example.demo.service.PptService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/PPT")
public class PptController {

    @Autowired
    private PptService pptService;

    /**
     * A aplicação deve expor um endpoint POST que receba as jogadas dos dois
     * jogadores e retorne o resultado da partida. As jogadas devem ser
     * informadas como strings: "PEDRA", "PAPEL" ou
     * "TESOURA" (case-insensitive). A resposta deve indicar: As jogadas de cada
     * jogador O resultado da partida: "Empate" "Jogador 1 vence" "Jogador 2
     * vence"
     */
    @PostMapping
    public ResponseEntity<PptDtoResponse> realizarJogada(
            @RequestBody @Valid final PptDtoRequest request) {
        
        PptDtoResponse response = pptService.realizarJogada(request);
        return ResponseEntity.ok(response);
    }

}
