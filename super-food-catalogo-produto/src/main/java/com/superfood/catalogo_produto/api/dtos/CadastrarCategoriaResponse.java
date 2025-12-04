package com.superfood.catalogo_produto.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarCategoriaResponse {
    private String id;
    private String nome;
    private String descricao;
}
