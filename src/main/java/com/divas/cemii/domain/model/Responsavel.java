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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_responsavel")
public class Responsavel {

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

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    @Column(name = "senha", length  = 254)
    private String senha;

    @Embedded
    private Endereco endereco;

    @NotBlank(message = "Este campo é obrigatório")
    @Column(name = "data_nascimento", columnDefinition = "datetime")
    private LocalDate nascimento;

    @NotBlank(message = "Este campo é obrigatório")
    private String foto;
}
