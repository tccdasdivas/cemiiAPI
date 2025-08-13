package com.divas.cemii.api.controller;

import com.divas.cemii.domain.model.Mensagem;
import com.divas.cemii.domain.repository.MensagemRepository;
import com.divas.cemii.domain.service.MensagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class MensagemController {

    private MensagemRepository mensagemRepository;

    private MensagemService mensagemService;

    public List<Mensagem> listar(){
        return mensagemRepository.findAll();
    }

    public ResponseEntity<Mensagem> buscar(@PathVariable Long mensagemId){
        Optional<Mensagem>mensagem = mensagemRepository.findById(mensagemId);

        if (mensagem.isPresent()){
            return ResponseEntity.ok(mensagem.get());
        }
        return ResponseEntity.notFound().build();
    }

    public Mensagem adicionar(@RequestBody Mensagem mensagem){
        return mensagemService.salvar(mensagem);
    }

    public ResponseEntity<Mensagem> atualizar(@PathVariable Long mensagemId, @RequestBody Mensagem mensagem){
        Optional<Mensagem> mensagemAtual = mensagemRepository.findById(mensagemId);

        if (mensagemAtual != null){
            BeanUtils.copyProperties(mensagem, mensagemAtual, "id");

            Mensagem mensagemSalva = mensagemService.salvar(mensagemAtual.get());
            return ResponseEntity.ok(mensagemSalva);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Mensagem> remover(@PathVariable Long mensagemId){
        try{
            mensagemService.excluir(mensagemId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        }
    }
}
