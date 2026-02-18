package com.microondas.domain.service;

import com.microondas.domain.model.ProgramaAquecimento;
import java.util.List;

public class ValidadorProgramaService {

    public void validarCaractere(String caractere, List<ProgramaAquecimento> programasExistentes) {
        if (caractere.equals(".")) {
            throw new RuntimeException("O caractere '.' não é permitido.");
        }

        boolean repetido = programasExistentes.stream()
                .anyMatch(p -> p.getCaractereAquecimento().equals(caractere));
        if (repetido) {
            throw new RuntimeException("Caractere já utilizado por outro programa.");
        }
    }
}