package com.microondas.domain.model;

import com.microondas.domain.exceptions.RegraNegocioException;

public class Microondas {

    private int tempo;
    private int potencia;
    private boolean emExecucao;
    private boolean pausado;

    private boolean programaPreDefinido;
    private String caractereProcessamento = ".";

    public void iniciar(int tempo, Integer potencia) {

        if (potencia == null) {
            potencia = 10;
        }

        validarTempoPotencia(tempo, potencia);

        this.tempo = tempo;
        this.potencia = potencia;
        this.emExecucao = true;
        this.pausado = false;
        this.caractereProcessamento = ".";
        this.programaPreDefinido = false;
    }

    private void validarTempoPotencia(int tempo, Integer potencia) {

        if (tempo < 1 || tempo > 120) {
            throw new RegraNegocioException("Tempo deve estar entre 1 e 120 segundos.");
        }

        if (potencia < 1 || potencia > 10) {
            throw new RegraNegocioException("Potência deve estar entre 1 e 10.");
        }
    }

    public void iniciarPrograma(ProgramaAquecimento programa) {
        this.tempo = programa.getTempo();
        this.potencia = programa.getPotencia();
        this.caractereProcessamento = programa.getCaractereAquecimento();
        this.programaPreDefinido = true;
    }

    public void inicioRapido() {
        this.tempo = 30;
        this.potencia = 10;
        this.emExecucao = true;
    }

    public void adicionarTempo(int segundos) {
        if (programaPreDefinido)
            return;
        this.tempo += segundos;
    }

    public void pausar() {
        if (!emExecucao)
            return;
        pausado = true;
    }

    public void cancelar() {
        tempo = 0;
        potencia = 0;
        emExecucao = false;
        pausado = false;
    }

    public void decrementar() {
        if (tempo > 0)
            tempo--;
    }

    public boolean finalizado() {
        return tempo == 0;
    }

    public String tempoFormatado() {
        int min = tempo / 60;
        int seg = tempo % 60;
        return String.format("%d:%02d", min, seg);
    }

    public String gerarProcessamento() {
        return caractereProcessamento.repeat(potencia);
    }

    public int getTempo() {
        return tempo;
    }

    public boolean isEmExecucao() {
        return emExecucao;
    }

    public boolean isPausado() {
        return pausado;
    }
}