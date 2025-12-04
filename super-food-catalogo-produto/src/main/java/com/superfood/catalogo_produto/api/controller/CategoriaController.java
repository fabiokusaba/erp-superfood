package com.superfood.catalogo_produto.api.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superfood.catalogo_produto.api.dtos.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.dtos.CadastrarCategoriaResponse;
import com.superfood.catalogo_produto.domain.model.Categoria;
import com.superfood.catalogo_produto.domain.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;
    private final ModelMapper modelMapper;

    @PostMapping
    public CadastrarCategoriaResponse cadastrar(@RequestBody CadastrarCategoriaRequest categoria) {
        var novaCategoria = new Categoria();
        novaCategoria.setId(UUID.randomUUID().toString());
        modelMapper.map(categoria, novaCategoria);
        var categoriaSalva = categoriaService.salvar(novaCategoria);
        return modelMapper.map(categoriaSalva, CadastrarCategoriaResponse.class);
    }
}
