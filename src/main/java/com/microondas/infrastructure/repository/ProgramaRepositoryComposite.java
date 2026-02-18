package com.microondas.infrastructure.repository;

import java.util.List;
import java.util.ArrayList;

import com.microondas.domain.model.ProgramaAquecimento;
import com.microondas.domain.repository.ProgramaRepository;

public abstract class ProgramaRepositoryComposite implements ProgramaRepository {

    private final ProgramaRepository preDefinido;
    private final ProgramaRepository customizado;

    public ProgramaRepositoryComposite(ProgramaRepository preDefinido, ProgramaRepository customizado) {
        this.preDefinido = preDefinido;
        this.customizado = customizado;
    }

    public List<ProgramaAquecimento> listarTodos() {
        List<ProgramaAquecimento> todos = new ArrayList<>();
        todos.addAll(preDefinido.listarTodos());
        todos.addAll(customizado.listarTodos());
        return todos;
    }
}