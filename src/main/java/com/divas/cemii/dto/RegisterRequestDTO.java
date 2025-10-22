package com.divas.cemii.dto;

import com.divas.cemii.domain.model.Cidade;

import java.time.LocalDate;

public record RegisterRequestDTO(
        String name,
        String email,
        String password,
        String telefone,
        String cpf,
        String foto,
        LocalDate nascimento,
        String parentesco,
        String profissao,
        Cidade cidade,
        String coren
) {}
