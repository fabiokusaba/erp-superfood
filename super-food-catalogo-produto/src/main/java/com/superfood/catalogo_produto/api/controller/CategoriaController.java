package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.dtos.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.dtos.CadastrarCategoriaResponse;
import com.superfood.catalogo_produto.api.mapper.CategoriaMapper;
import com.superfood.catalogo_produto.domain.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    @PostMapping
    public CadastrarCategoriaResponse cadastrar(@RequestBody CadastrarCategoriaRequest request) {
        var categoria = categoriaMapper.toDomainModel(request);
        categoriaService.salvar(categoria);
        return categoriaMapper.toResponse(categoria);
    }
}
