package com.divas.cemii.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.SplittableRandom;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_familia")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @ManyToOne
    @JoinColumn(name="grauParentesco_id")
    private GrauParentesco grauParentesco;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name="estado_id")
    private Estado estado;

    private String nascimento;
}
