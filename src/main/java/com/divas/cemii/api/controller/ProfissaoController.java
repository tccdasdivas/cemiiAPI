package com.divas.cemii.api.controller;

import com.divas.cemii.domain.exception.EntidadeEmUsoException;
import com.divas.cemii.domain.model.Profissao;
import com.divas.cemii.domain.repository.ProfissaoRepository;
import com.divas.cemii.domain.service.ProfissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/profissoes")
@RestController
public class ProfissaoController {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    @Autowired
    private ProfissaoService profissaoService;

    @GetMapping
    public List<Profissao> listar(){
        return profissaoRepository.findAll();
    }

    @GetMapping("/{profissaoId}")
    public ResponseEntity<Profissao> buscar(@PathVariable Long profissaoId){
        Optional <Profissao> profissao = profissaoRepository.findById(profissaoId);

        if (profissao.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissao adicionar(@RequestBody Profissao profissao){
        return profissaoService.salvar(profissao);
    }

    @PutMapping("/{profissaoId}")
    public ResponseEntity<Profissao> atualizar(@PathVariable Long profissaoId, @RequestBody Profissao profissao){
        Optional <Profissao> profissaoAtual = profissaoRepository.findById(profissaoId);

        if (profissaoAtual != null){
            BeanUtils.copyProperties(profissao, profissaoAtual, "id");

            Profissao profissaoSalva = profissaoService.salvar(profissaoAtual.get());
            return ResponseEntity.ok(profissaoSalva);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{profissaoId}")
    public ResponseEntity<Profissao> remover(@PathVariable Long profissaoId){
        try{
            profissaoService.excluir(profissaoId);
            return ResponseEntity.notFound().build();
        } catch (EnumConstantNotPresentException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
