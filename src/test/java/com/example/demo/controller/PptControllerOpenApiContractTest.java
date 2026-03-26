package com.example.demo.controller;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.example.demo.dto.JogadaEnum;
import com.example.demo.dto.PptDtoResponse;
import com.example.demo.dto.ResultadoEnum;
import com.example.demo.service.PptService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PptController.class)
class PptControllerOpenApiContractTest {

    private static final OpenApiInteractionValidator OPEN_API_VALIDATOR =
            OpenApiInteractionValidator.createFor("src/test/resources/openapi/ppt-api.yaml")
                    .build();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PptService pptService;

    @Test
    void deveValidarContratoParaRespostaDeSucesso() throws Exception {
        PptDtoResponse response = PptDtoResponse.builder()
                .id(1L)
                .dataHora(LocalDateTime.of(2026, 3, 26, 21, 30, 0))
                .jogador1(JogadaEnum.PEDRA)
                .jogador2(JogadaEnum.TESOURA)
                .resultado(ResultadoEnum.JOGADOR_1_VENCE)
                .build();
        when(pptService.realizarJogada(org.mockito.ArgumentMatchers.any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/PPT")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                {
                                  "jogador1": "PEDRA",
                                  "jogador2": "TESOURA"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(openApi().isValid(OPEN_API_VALIDATOR));
    }

    @Test
    void deveValidarContratoParaErroQuandoCampoObrigatorioAusente() throws Exception {
        mockMvc.perform(post("/api/v1/PPT")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                {
                                  "jogador1": "PEDRA"
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(openApi().isValid(OPEN_API_VALIDATOR));
    }
}