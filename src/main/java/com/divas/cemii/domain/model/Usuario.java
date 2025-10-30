package com.divas.cemii.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    //@NotBlank(message = "Este campo é obrigatório")
    private String nome;

    //@NotBlank(message = "Este campo é obrigatório")
    private String email;

    //@NotBlank(message = "Este campo é obrigatório")
    private String telefone;

    //@NotBlank(message = "Este campo é obrigatório")
    private String cpf;

    //@NotBlank(message = "Este campo é obrigatório")
    private String foto;

    //@NotBlank(message = "Este campo é obrigatório")
    private String parentesco;

    //@NotBlank(message = "Este campo é obrigatório")
    private String profissao;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Column(name = "senha", length  = 254)
    private String senha;

    @Embedded
    private Endereco endereco;

    //@NotBlank(message = "Este campo é obrigatório")
    @Column(name = "data_nascimento", columnDefinition = "datetime")
    private LocalDate nascimento;

    private String coren;

    private String logradouro;

    private String numero;

    private String necessidade;
}
