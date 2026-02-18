package com.microondas.presentation.controller;

import com.microondas.application.usecases.MicroondasUseCase;
import com.microondas.domain.exceptions.RegraNegocioException;

public class MicroondasController {

    private final MicroondasUseCase useCase;

    public MicroondasController(MicroondasUseCase useCase) {
        this.useCase = useCase;
    }

    public String iniciar(String tempo, String potencia) {
        try {
            int tempoInt = Integer.parseInt(tempo);
            Integer potInt = potencia.isBlank() ? null : Integer.parseInt(potencia);

            useCase.iniciar(tempoInt, potInt);
            return null;

        } catch (NumberFormatException e) {
            return "Informe apenas números.";
        } catch (RegraNegocioException e) {
            return e.getMessage();
        }
    }

    public void inicioRapido() {
        useCase.inicioRapido();
    }

    public void adicionarTempo() {
        useCase.adicionarTempo();
    }

    public void pausar() {
        useCase.pausar();
    }

    public void cancelar() {
        useCase.cancelar();
    }

    public void tick() {
        useCase.tick();
    }

    public boolean finalizado() {
        return useCase.finalizado();
    }

    public String tempo() {
        return useCase.tempoFormatado();
    }

    public String processamento() {
        return useCase.processamento();
    }

    public boolean emExecucao() {
        return useCase.emExecucao();
    }

    public boolean pausado() {
        return useCase.pausado();
    }
}