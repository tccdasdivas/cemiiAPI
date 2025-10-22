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


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario responsavel;
}
