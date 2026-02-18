package domain.model;

import com.microondas.domain.exceptions.RegraNegocioException;
import com.microondas.domain.model.Microondas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MicroondasTest {

    @Test
    void deveIniciarComTempoEpotenciaValidos() {
        Microondas micro = new Microondas();
        micro.iniciar(60, 5);
        assertEquals("1:00", micro.tempoFormatado());
        assertTrue(micro.isEmExecucao());
    }

    @Test
    void deveLancarErroSeTempoMenorQueUm() {
        Microondas micro = new Microondas();
        assertThrows(RegraNegocioException.class, () -> micro.iniciar(0, 5));
    }

    @Test
    void deveLancarErroSeTempoMaiorQue120() {
        Microondas micro = new Microondas();
        assertThrows(RegraNegocioException.class, () -> micro.iniciar(121, 5));
    }

    @Test
    void deveAssumirPotenciaPadraoQuandoNull() {
        Microondas micro = new Microondas();
        micro.iniciar(30, null);
        assertEquals("0:30", micro.tempoFormatado());
    }

    @Test
    void deveLancarErroSePotenciaInvalida() {
        Microondas micro = new Microondas();
        assertThrows(RegraNegocioException.class, () -> micro.iniciar(30, 11));
    }

    @Test
    void deveExecutarInicioRapido() {
        Microondas micro = new Microondas();
        micro.inicioRapido();
        assertEquals("0:30", micro.tempoFormatado());
        assertTrue(micro.isEmExecucao());
    }

    @Test
    void deveDecrementarTempo() {
        Microondas micro = new Microondas();
        micro.iniciar(10, 5);
        micro.decrementar();
        assertEquals("0:09", micro.tempoFormatado());
    }

    @Test
    void deveFinalizarQuandoTempoZero() {
        Microondas micro = new Microondas();
        micro.iniciar(1, 5);
        micro.decrementar();
        assertTrue(micro.finalizado());
    }

    @Test
    void deveGerarProcessamentoComBaseNaPotencia() {
        Microondas micro = new Microondas();
        micro.iniciar(10, 3);
        String processamento = micro.gerarProcessamento();
        assertEquals("...".length(), processamento.length());
    }

    @Test
    void deveFormatarTempoCorretamente() {
        Microondas micro = new Microondas();
        micro.iniciar(90, 5);
        assertEquals("1:30", micro.tempoFormatado());
    }
}