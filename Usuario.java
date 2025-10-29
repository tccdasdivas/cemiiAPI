package com.divas.cemii.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    private String foto;

    private String parentesco;

    private String profissao;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Column(name = "senha", length  = 254)
    private String senha;

    @Column(name = "data_nascimento", columnDefinition = "datetime")
    private LocalDate nascimento;

    private String coren;

    private String logradouro;

    private String numero;

    private String necessidade;
}
