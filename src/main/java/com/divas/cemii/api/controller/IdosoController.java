package com.divas.cemii.api.controller;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.model.Cidade;
import com.divas.cemii.domain.model.Idoso;
import com.divas.cemii.domain.repository.IdosoRepository;
import com.divas.cemii.domain.service.IdosoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/idosos")
@RestController
public class IdosoController {

    @Autowired
    private IdosoRepository idosoRepository;

    @Autowired
    private IdosoService idosoService;

    @GetMapping
    public List<Idoso> listar(){
        return idosoRepository.findAll();
    }
    
    @GetMapping("/{idosoId}")
    public ResponseEntity<Idoso> buscar(@PathVariable Long idosoId){
        Optional <Idoso> idoso = idosoRepository.findById(idosoId);

        if(idoso.isPresent()){
            return ResponseEntity.ok(idoso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Idoso adicionar(@RequestBody Idoso idoso){
        return idosoService.salvar(idoso);
    }

    @PutMapping("/{idosoId}")
    public ResponseEntity<Idoso> atualizar(@PathVariable Long idosoId, @RequestBody Idoso idoso){
        Optional <Idoso> idosoAtual = idosoRepository.findById(idosoId);

        if (idosoAtual != null){
            BeanUtils.copyProperties(idoso, idosoAtual, "id");

            Idoso idosoSalva = idosoService.salvar(idosoAtual.get());
            return ResponseEntity.ok(idosoSalva);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idosoId}")
    public ResponseEntity<Idoso> remover(@PathVariable Long idosoId){
        try{
            idosoService.excluir(idosoId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
