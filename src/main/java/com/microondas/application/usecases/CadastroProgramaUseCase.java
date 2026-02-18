package com.microondas.application.usecases;

import com.microondas.domain.model.ProgramaAquecimento;
import com.microondas.domain.model.TipoPrograma;
import com.microondas.domain.repository.ProgramaRepository;
import com.microondas.domain.service.ValidadorProgramaService;
import java.util.List;

public class CadastroProgramaUseCase {

    private final ProgramaRepository repository;

    private final ValidadorProgramaService validador;

    public CadastroProgramaUseCase(ProgramaRepository repository) {
        this.repository = repository;
        this.validador = new ValidadorProgramaService();
    }

    public void cadastrar(String nome, String alimento, int tempo, int potencia, String caractere, String instrucoes) {
        if (nome.isBlank() || alimento.isBlank() || caractere.isBlank()) {
            throw new RuntimeException("Campos obrigatórios não preenchidos.");
        }

        List<ProgramaAquecimento> existentes = repository.listarTodos();

        validador.validarCaractere(caractere, existentes);

        ProgramaAquecimento novo = new ProgramaAquecimento(nome, alimento, tempo, potencia, caractere, instrucoes,
                TipoPrograma.CUSTOMIZADO);

        repository.salvar(novo);
    }
}