package com.divas.cemii.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Table(name = "tb_cuidador")
public class Cuidador {
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
    @ManyToOne
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Embedded
    private Endereco endereco;

    @NotBlank(message = "Este campo é obrigatório")
    private String nascimento;

    @CreationTimestamp
    @Column(name = "data_cadastro", columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;
}
