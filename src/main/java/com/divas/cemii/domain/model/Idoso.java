package com.divas.cemii.domain.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_idoso")
public class Idoso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String necessidade;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    private String nascimento;
}
