package com.divas.cemii.api.controller;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.model.GrauParentesco;
import com.divas.cemii.domain.repository.GrauParentescoRepository;
import com.divas.cemii.domain.service.GrauParentescoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/grauparentescos")
@RestController
public class GrauParentescoController {

    @Autowired
    private GrauParentescoRepository grauParentescoRepository;

    @Autowired
    private GrauParentescoService grauParentescoService;

    @GetMapping
    public List<GrauParentesco> listar(){
        return grauParentescoRepository.findAll();
    }

    @GetMapping("/{grauParentescoId}")
    public ResponseEntity<GrauParentesco> buscar(@PathVariable Long grauParentescoId){
        Optional <GrauParentesco> grauParentesco = grauParentescoRepository.findById(grauParentescoId);

        if (grauParentesco.isPresent()){
            return ResponseEntity.ok(grauParentesco.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrauParentesco adicionar(@RequestBody GrauParentesco grauParentesco){
        return grauParentescoService.salvar(grauParentesco);
    }

    @PutMapping("/{grauParentescoId}")
    public ResponseEntity<GrauParentesco> atualizar(@PathVariable Long grauParentescoId, @RequestBody GrauParentesco grauParentesco){
        Optional <GrauParentesco> grauParentescoAtual = grauParentescoRepository.findById(grauParentescoId);

        if (grauParentescoAtual != null){
            BeanUtils.copyProperties(grauParentesco, grauParentescoAtual, "id");

            GrauParentesco grauParentescoSalva = grauParentescoService.salvar(grauParentescoAtual.get());
            return ResponseEntity.ok(grauParentescoSalva);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{grauParentescoId}")
    public ResponseEntity<GrauParentesco> remover(@PathVariable Long grauParentescoId){
        try{
            grauParentescoService.excluir(grauParentescoId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
