package com.divas.cemii.api.controller;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.model.Cuidador;
import com.divas.cemii.domain.repository.CuidadorRepository;
import com.divas.cemii.domain.service.CuidadorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/cuidadores")
@RestController
public class CuidadorController {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    @Autowired
    private CuidadorService cuidadorService;

    @GetMapping
    public List<Cuidador> listar(){
        return cuidadorRepository.findAll();
    }

    @GetMapping("/{cuidadorId}")
    public ResponseEntity<Cuidador> buscar(@PathVariable Long cuidadorId){
        Optional <Cuidador> cuidador = cuidadorRepository.findById(cuidadorId);

        if (cuidador.isPresent()){
            return ResponseEntity.ok(cuidador.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cuidador adicionar(@RequestBody Cuidador cuidador){
        return cuidadorService.salvar(cuidador);
    }

    @PutMapping("/{cuidadorId}")
    public ResponseEntity<Cuidador> atualizar(@PathVariable Long cuidadorId, @RequestBody Cuidador cuidador){
        Optional <Cuidador> cuidadorAtual = cuidadorRepository.findById(cuidadorId);

        if (cuidadorAtual != null){
            BeanUtils.copyProperties(cuidador, cuidadorAtual, "id");

            Cuidador cuidadorSalva = cuidadorService.salvar(cuidadorAtual.get());
            return ResponseEntity.ok(cuidadorSalva);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cuidadorId}")
    public ResponseEntity<Cuidador> remover(@PathVariable Long cuidadorId){
        try {
            cuidadorService.excluir(cuidadorId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
