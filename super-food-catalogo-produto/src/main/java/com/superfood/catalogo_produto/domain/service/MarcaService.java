package com.superfood.catalogo_produto.domain.service;

import com.superfood.catalogo_produto.domain.model.Marca;
import com.superfood.catalogo_produto.domain.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public Marca salvar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca buscarPorId(String id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca inexistente"));
    }

    public List<Marca> listar() {
        return marcaRepository.findAll();
    }

    public void excluir(String id) {
        var marcaExistente = buscarPorId(id);
        marcaRepository.delete(marcaExistente);
    }
}
