package com.divas.cemii.api.controller;

import com.divas.cemii.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cidades")
@RestController
public class CidadeController {

    private CidadeRepository cidadeRepository;
}
