package com.divas.cemii.api.controller;


import com.divas.cemii.domain.model.Estado;
import com.divas.cemii.domain.repository.EstadoRepository;
import com.divas.cemii.domain.service.EstadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/estados")
@RestController
public class EstadoController {
    private EstadoRepository estadoRepository;

    private EstadoService estadoService;

    public List<Estado> listar(){
        return estadoRepository.findAll();
    }
}
