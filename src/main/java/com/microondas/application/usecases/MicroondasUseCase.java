package com.microondas.application.usecases;

import java.util.List;

import com.microondas.domain.model.Microondas;
import com.microondas.domain.model.ProgramaAquecimento;
import com.microondas.domain.repository.ProgramaRepository;

public class MicroondasUseCase {

    private final Microondas microondas;

    private final ProgramaRepository repository;

    public MicroondasUseCase(Microondas microondas, ProgramaRepository repository) {
        this.microondas = microondas;
        this.repository = repository;
    }

    public void iniciarPrograma(String nomePrograma) {
        var programa = repository.buscarPorNome(nomePrograma)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));
        microondas.iniciarPrograma(programa);
    }

    public List<ProgramaAquecimento> listarProgramas() {
        return repository.listarTodos();
    }

    public void iniciar(int tempo, Integer potencia) {
        microondas.iniciar(tempo, potencia);
    }

    public void inicioRapido() {
        microondas.inicioRapido();
    }

    public void adicionarTempo() {
        microondas.adicionarTempo(30);
    }

    public void pausar() {
        microondas.pausar();
    }

    public void cancelar() {
        microondas.cancelar();
    }

    public void tick() {
        microondas.decrementar();
    }

    public boolean finalizado() {
        return microondas.finalizado();
    }

    public String tempoFormatado() {
        return microondas.tempoFormatado();
    }

    public String processamento() {
        return microondas.gerarProcessamento();
    }

    public boolean emExecucao() {
        return microondas.isEmExecucao();
    }

    public boolean pausado() {
        return microondas.isPausado();
    }
}