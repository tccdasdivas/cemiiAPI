package com.divas.cemii.domain.service;


import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.exception.EntidadeNaoEncontradaException;
import com.divas.cemii.domain.model.GrauParentesco;
import com.divas.cemii.domain.repository.GrauParentescoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class GrauParentescoService {
    @Autowired
    private GrauParentescoRepository grauParentescoRepository;

    public GrauParentesco salvar(GrauParentesco grauParentesco) {
        return grauParentescoRepository.save(grauParentesco);
    }

    public void excluir(Long id) {
        try {
            grauParentescoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Grau de Parentesco ou código %d não pode ser removida, pois está em uso.", id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de grau de parentesco %d", id));
        }
    }
}