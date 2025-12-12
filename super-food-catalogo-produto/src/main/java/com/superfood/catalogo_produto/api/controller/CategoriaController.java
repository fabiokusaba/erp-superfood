package com.superfood.catalogo_produto.api.controller;

import com.superfood.catalogo_produto.api.dtos.AtualizarCategoriaRequest;
import com.superfood.catalogo_produto.api.dtos.AtualizarCategoriaResponse;
import com.superfood.catalogo_produto.api.dtos.CadastrarCategoriaRequest;
import com.superfood.catalogo_produto.api.dtos.CadastrarCategoriaResponse;
import com.superfood.catalogo_produto.api.mapper.CategoriaMapper;
import com.superfood.catalogo_produto.domain.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return categoriaMapper.cadastroResponse(categoria);
    }

    @PutMapping("/{categoriaId}")
    public AtualizarCategoriaResponse atualizar(@PathVariable String categoriaId, @RequestBody AtualizarCategoriaRequest request) {
        var categoriaExistente = categoriaService.buscarPorId(categoriaId);
        categoriaMapper.copyToDomainModel(request, categoriaExistente);
        categoriaService.salvar(categoriaExistente);
        return categoriaMapper.atualizarResponse(categoriaExistente);
    }
}
