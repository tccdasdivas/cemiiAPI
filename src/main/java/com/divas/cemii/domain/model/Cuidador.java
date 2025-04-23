package com.divas.cemii.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Table(name = "tb_cuidador")
public class Cuidador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    private String nascimento;
}
