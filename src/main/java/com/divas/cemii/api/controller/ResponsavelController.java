package com.divas.cemii.api.controller;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.model.Responsavel;
import com.divas.cemii.domain.repository.ResponsavelRepository;
import com.divas.cemii.domain.service.ResponsavelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/responsaveis")
@RestController
public class ResponsavelController {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public List<Responsavel> listar(){
        return responsavelRepository.findAll();
    }

    @GetMapping("/{responsavelId}")
    public ResponseEntity<Responsavel> buscar(@PathVariable Long responsavelId){
        Optional <Responsavel> responsavel = responsavelRepository.findById(responsavelId);

        if (responsavel.isPresent()){
            return ResponseEntity.ok(responsavel.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Responsavel adicionar(@RequestBody Responsavel responsavel){
        return responsavelService.salvar(responsavel);
    }

    public ResponseEntity<Responsavel> verificar(@RequestBody Responsavel responsavel) {
        Responsavel salvo = responsavelService.verificar(responsavel.getNascimento());
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{responsavelId}")
    public ResponseEntity<Responsavel> atualizar(@PathVariable Long responsavelId, @RequestBody Responsavel responsavel){
        Optional <Responsavel> responsavelAtual = responsavelRepository.findById(responsavelId);

        if (responsavelAtual != null){
            BeanUtils.copyProperties(responsavel, responsavelAtual, "id");

            Responsavel responsavelSalva = responsavelService.salvar(responsavelAtual.get());
            return ResponseEntity.ok(responsavelSalva);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{responsavelId}")
    public ResponseEntity<Responsavel> remover(@PathVariable Long responsavelId){
        try{
            responsavelService.excluir(responsavelId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
