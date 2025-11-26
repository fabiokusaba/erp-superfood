package com.superfood.catalogo_produto.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "marca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Marca {
    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String nome;
    private String descricao;
}
