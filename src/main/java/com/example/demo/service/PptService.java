package com.example.demo.service;

import com.example.demo.dto.PptDtoRequest;
import com.example.demo.dto.PptDtoResponse;

public interface PptService {
    
    PptDtoResponse realizarJogada(PptDtoRequest request);    
}
