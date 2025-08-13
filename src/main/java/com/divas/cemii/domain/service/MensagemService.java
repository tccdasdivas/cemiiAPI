package com.divas.cemii.domain.service;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.exception.EntidadeNaoEncontradaException;
import com.divas.cemii.domain.model.Mensagem;
import com.divas.cemii.domain.repository.MensagemRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

public class MensagemService {

    private MensagemRepository mensagemRepository;

    public Mensagem salvar(Mensagem mensagem){
        return mensagemRepository.save(mensagem);
    }

    public void excluir(Long id){
        try{
            mensagemRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Mensagem não encontrada %d", id));
        }
    }
}
