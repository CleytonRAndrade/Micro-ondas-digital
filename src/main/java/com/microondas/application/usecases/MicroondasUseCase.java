package com.microondas.application.usecases;

import com.microondas.domain.model.Microondas;

public class MicroondasUseCase {

    private final Microondas microondas;

    public MicroondasUseCase(Microondas microondas) {
        this.microondas = microondas;
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