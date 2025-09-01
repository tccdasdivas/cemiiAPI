package com.divas.cemii.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_idoso")
public class Idoso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "Este campo é obrigatório")
    private String nome;

    @NotBlank(message = "Este campo é obrigatório")
    private String email;

    @NotBlank(message = "Este campo é obrigatório")
    private String telefone;

    @NotBlank(message = "Este campo é obrigatório")
    private String cpf;

    @NotBlank(message = "Este campo é obrigatório")
    private String foto;

    @NotBlank(message = "Este campo é obrigatório")
    private String necessidades;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Embedded
    private Endereco endereco;

    @NotBlank(message = "Este campo é obrigatório")
    @Column(name = "data_nascimento", columnDefinition = "datetime")
    private LocalDate nascimento;

    @CreationTimestamp
    @Column(name = "data_cadastro", columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name="grauparentesco_id")
    private GrauParentesco grauParentesco;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;
}
