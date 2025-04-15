package com.divas.cemii.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_grauparentesco")
public class GrauParentesco {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mae;
    private String pai;
    private String filho;
    private String irmao;
    private String neto;
    private String nora;
    private String genro;
}
