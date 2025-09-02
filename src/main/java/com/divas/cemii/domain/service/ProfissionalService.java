package com.divas.cemii.domain.service;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.exception.EntidadeNaoEncontradaException;
import com.divas.cemii.domain.model.Profissional;
import com.divas.cemii.domain.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional salvar(Profissional profissional){
        return profissionalRepository.save(profissional);
    }

    public void excluir(Long id){
        try{
            profissionalRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Profissional ou código %d não pode ser removida, pois está em uso.", id));
        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de profissional %d", id));
        }
    }
}
