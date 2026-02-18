package com.microondas.domain.repository;

import com.microondas.domain.model.ProgramaAquecimento;
import java.util.List;
import java.util.Optional;

public interface ProgramaRepository {

    List<ProgramaAquecimento> listarTodos();

    Optional<ProgramaAquecimento> buscarPorNome(String nome);

}