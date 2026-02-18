package com.microondas.domain.model;

public class ProgramaAquecimento {

    private final String nome;
    private final String alimento;
    private final int tempo;
    private final int potencia;
    private final String caractereAquecimento;
    private final String instrucoes;

    public ProgramaAquecimento(String nome,
            String alimento,
            int tempo,
            int potencia,
            String caractereAquecimento,
            String instrucoes) {

        this.nome = nome;
        this.alimento = alimento;
        this.tempo = tempo;
        this.potencia = potencia;
        this.caractereAquecimento = caractereAquecimento;
        this.instrucoes = instrucoes;
    }

    public String getNome() {
        return nome;
    }

    public String getAlimento() {
        return alimento;
    }

    public int getTempo() {
        return tempo;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getCaractereAquecimento() {
        return caractereAquecimento;
    }

    public String getInstrucoes() {
        return instrucoes;
    }
}