package com.divas.cemii.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private String necessidade;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @NotBlank(message = "Este campo é obrigatório")
    private String nascimento;

    @CreationTimestamp
    @Column(name = "data_cadastro", columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;
}
