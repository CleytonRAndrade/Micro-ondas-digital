package com.microondas.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microondas.domain.model.ProgramaAquecimento;
import com.microondas.domain.repository.ProgramaRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgramaCustomizadoJsonRepository implements ProgramaRepository {

    private final File arquivo = new File("programas_customizados.json");
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<ProgramaAquecimento> listarTodos() {
        try {
            if (!arquivo.exists())
                return new ArrayList<>();

            return mapper.readValue(arquivo, new TypeReference<List<ProgramaAquecimento>>() {
            });
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<ProgramaAquecimento> buscarPorNome(String nome) {
        return listarTodos().stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    @Override
    public void salvar(ProgramaAquecimento programa) {
        try {
            List<ProgramaAquecimento> lista = listarTodos();
            lista.add(programa);
            mapper.writerWithDefaultPrettyPrinter().writeValue(arquivo, lista);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar programa.");
        }
    }
}