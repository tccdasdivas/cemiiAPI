package com.divas.cemii.domain.service;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.exception.EntidadeNaoEncontradaException;
import com.divas.cemii.domain.model.Cuidador;
import com.divas.cemii.domain.repository.CuidadorRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CuidadorService {

    private CuidadorRepository cuidadorRepository;

    public Cuidador salvar(Cuidador cuidador){
        return cuidadorRepository.save(cuidador);
    }

    public void excluir(Long id){
        try{
            cuidadorRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Cuidador ou código %d não pode ser removida, pois está em uso.", id));
        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cuidador %d", id));
        }
    }
}
