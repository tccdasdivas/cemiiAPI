package com.divas.cemii.domain.service;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.exception.EntidadeNaoEncontradaException;
import com.divas.cemii.domain.model.Idoso;
import com.divas.cemii.domain.model.Responsavel;
import com.divas.cemii.domain.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public Responsavel salvar(Responsavel responsavel){return responsavelRepository.save(responsavel);
    }

    public Responsavel verificar(LocalDate nascimento){

        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(nascimento, dataAtual).getYears();

        if (idade >= 18) {
            Responsavel novoResponsavel = new Responsavel();
            novoResponsavel.setNascimento(nascimento);
            return responsavelRepository.save(novoResponsavel);
        } else {throw new IllegalArgumentException("Cadastro não permitido: menor de idade.");
        }
    }

    public void excluir(Long id){
        try{
            responsavelRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Responsável ou código %d não pode ser removida, pois está em uso.", id));
        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de responsável %d", id));
        }
    }


}
