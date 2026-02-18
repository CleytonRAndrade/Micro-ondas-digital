package com.microondas.infrastructure.repository;

import com.microondas.domain.model.ProgramaAquecimento;
import com.microondas.domain.repository.ProgramaRepository;

import java.util.List;
import java.util.Optional;

public class ProgramaRepositoryImpl implements ProgramaRepository {

    private final List<ProgramaAquecimento> programas = List.of(

            new ProgramaAquecimento(
                    "Pipoca",
                    "Pipoca de micro-ondas",
                    180, // 3 minutos
                    7,
                    "*",
                    "Observar o barulho de estouro do milho, caso houver um intervalo de mais 10 segundos entre um estouro e outro, interrompa o aquecimento."),

            new ProgramaAquecimento(
                    "Leite",
                    "Leite",
                    300, // 5 minutos
                    5,
                    "#",
                    "Cuidado com aquecimento de líquidos, o choque térmico aliado ao movimento do recipiente pode causar fervura imediata causando risco de queimaduras."),

            new ProgramaAquecimento(
                    "Carnes de boi",
                    "Carne em pedaço ou fatias",
                    840, // 14 minutos
                    4,
                    "@",
                    "Interrompa o processo na metade e vire o conteúdo com a parte de baixo para cima para o descongelamento uniforme."),

            new ProgramaAquecimento(
                    "Frango",
                    "Frango (qualquer corte)",
                    480, // 8 minutos
                    7,
                    "%",
                    "Interrompa o processo na metade e vire o conteúdo com a parte de baixo para cima para o descongelamento uniforme."),

            new ProgramaAquecimento(
                    "Feijão",
                    "Feijão congelado",
                    480, // 8 minutos
                    9,
                    "$",
                    "Deixe o recipiente destampado e, em casos de plástico, cuidado ao retirar o recipiente pois o mesmo pode perder resistência em altas temperaturas."));

    @Override
    public List<ProgramaAquecimento> listarTodos() {
        return programas;
    }

    @Override
    public Optional<ProgramaAquecimento> buscarPorNome(String nome) {
        return programas.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}