package com.divas.cemii.api.controller;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.model.Profissional;
import com.divas.cemii.domain.repository.ProfissionalRepository;
import com.divas.cemii.domain.service.ProfissionalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/profissionais")
@RestController
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public List<Profissional> listar(){
        return profissionalRepository.findAll();
    }

    @GetMapping("/{profissionalId}")
    public ResponseEntity<Profissional> buscar(@PathVariable Long profissionalId){
        Optional <Profissional> profissional = profissionalRepository.findById(profissionalId);

        if (profissional.isPresent()){
            return ResponseEntity.ok(profissional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional adicionar(@RequestBody Profissional profissional){
        return profissionalService.salvar(profissional);
    }

    @PutMapping("/{profissionalId}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long profissionalId, @RequestBody Profissional profissional){
        Optional <Profissional> profissionalAtual = profissionalRepository.findById(profissionalId);

        if (profissionalAtual != null){
            BeanUtils.copyProperties(profissional, profissionalAtual, "id");

            Profissional profissionalSalva = profissionalService.salvar(profissionalAtual.get());
            return ResponseEntity.ok(profissionalSalva);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{profissionalId}")
    public ResponseEntity<Profissional> remover(@PathVariable Long profissionalId){
        try {
            profissionalService.excluir(profissionalId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
