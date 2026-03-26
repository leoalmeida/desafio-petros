package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PptControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveAceitarJogadasCaseInsensitiveERetornarResultadoDescritivo() throws Exception {
        mockMvc.perform(
                        post("/api/v1/PPT")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        """
                                {
                                  "id": 1,
                                  "jogador1": "papel",
                                  "jogador2": "Pedra"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jogador1").value("PAPEL"))
                .andExpect(jsonPath("$.jogador2").value("PEDRA"))
                .andExpect(jsonPath("$.resultado").value("Jogador 1 vence"))
                .andExpect(jsonPath("$.dataHora").isNotEmpty());
    }

    @Test
    void deveRetornarBadRequestQuandoJogadaForInvalida() throws Exception {
        mockMvc.perform(
                        post("/api/v1/PPT")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        """
                                {
                                  "id": 1,  
                                  "jogador1": "lagarto",
                                  "jogador2": "pedra"
                                }
                                """))
                                                                .andExpect(status().isBadRequest())
                                                                .andExpect(jsonPath("$.status").value(400))
                                                                .andExpect(jsonPath("$.error").value("Bad Request"))
                                                                .andExpect(jsonPath("$.message").value("Corpo da requisicao invalido"))
                                                                .andExpect(jsonPath("$.path").value("/api/v1/PPT"))
                                                                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    @Test
    void deveRetornarBadRequestQuandoJogador2NaoForInformado() throws Exception {
        mockMvc.perform(
                        post("/api/v1/PPT")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        """
                                {
                                  "jogador1": "pedra"
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Erro de validacao"))
                .andExpect(jsonPath("$.fieldErrors.jogador2").value("jogador2 e obrigatorio"))
                .andExpect(jsonPath("$.path").value("/api/v1/PPT"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }
}
