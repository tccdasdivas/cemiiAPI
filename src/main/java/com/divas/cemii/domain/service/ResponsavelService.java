package com.divas.cemii.domain.service;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.exception.EntidadeNaoEncontradaException;
import com.divas.cemii.domain.model.Responsavel;
import com.divas.cemii.domain.repository.ResponsavelRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {

    private ResponsavelRepository responsavelRepository;

    public Responsavel salvar(Responsavel responsavel){
        return responsavelRepository.save(responsavel);
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
