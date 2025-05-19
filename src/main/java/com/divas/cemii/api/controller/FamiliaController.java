package com.divas.cemii.api.controller;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.model.Familia;
import com.divas.cemii.domain.repository.FamiliaRepository;
import com.divas.cemii.domain.service.FamiliaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/{familias}")
@RestController
public class FamiliaController {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private FamiliaService familiaService;

    @GetMapping
    public List<Familia> listar(){
        return familiaRepository.findAll();
    }

    @GetMapping("/{familiaId}")
    public ResponseEntity<Familia> buscar(@PathVariable Long familiaId){
        Optional <Familia> familia = familiaRepository.findById(familiaId);

        if (familia.isPresent()){
            return ResponseEntity.ok(familia.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Familia adicionar(@RequestBody Familia familia){
        return familiaService.salvar(familia);
    }

    @PutMapping("/{familiaId}")
    public ResponseEntity<Familia> atualizar(@PathVariable Long familiaId, @RequestBody Familia familia){
        Optional <Familia> familiaAtual = familiaRepository.findById(familiaId);

        if (familiaAtual != null){
            BeanUtils.copyProperties(familia, familiaAtual, "id");

            Familia familiaSalva = familiaService.salvar(familiaAtual.get());
            return ResponseEntity.ok(familiaSalva);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{familiaId}")
    public ResponseEntity<Familia> remover(@PathVariable Long familiaId){
        try{
            familiaService.excluir(familiaId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
