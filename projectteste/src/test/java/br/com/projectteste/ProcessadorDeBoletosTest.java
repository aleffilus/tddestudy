package br.com.projectteste;

import br.com.projectteste.domain.Boleto;
import br.com.projectteste.domain.Fatura;
import br.com.projectteste.domain.ProcessadorDeBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alessandro Oliveira
 * @since 08/06/2017.
 */
public class ProcessadorDeBoletosTest {

    private ProcessadorDeBoletos processadorDeBoletos;
    private float delta;

    @BeforeEach
    public void inicializa () {
        processadorDeBoletos = new ProcessadorDeBoletos();
        delta = 0.00001f;
    }

    @Test
    public  void deveProcessarPagamentoViaBoleto () {
        Fatura fatura = new Fatura("Cliente", 150L);
        Boleto boleto = new Boleto(150L);
        List<Boleto> boletos = Arrays.asList(boleto);

        processadorDeBoletos.processa(boletos, fatura);

        assertEquals(1, fatura.getPagamentos().size());
        assertEquals(150L, fatura.getPagamentos().get(0).getValor(), delta);

    }

    @Test
    public void deveProcessarPagamentoViaMuitosBoletos () {
        Fatura fatura = new Fatura("Cliente", 300L);
        Boleto boleto1 = new Boleto(100L);
        Boleto boleto2 = new Boleto(200L);

        List<Boleto> boletos = Arrays.asList(boleto1, boleto2);

        processadorDeBoletos.processa(boletos, fatura);

        assertEquals(2, fatura.getPagamentos().size());
        assertEquals(100L, fatura.getPagamentos().get(0).getValor(), delta);
        assertEquals(200L, fatura.getPagamentos().get(1).getValor(), delta);
    }

    @Test
    public void deveMarcarFaturaComoPagaCasoBoletoUnicoPagueTudo () {
        Fatura fatura = new Fatura("Cliente", 150L);
        Boleto boleto = new Boleto(150L);
        List<Boleto> boletos = Arrays.asList(boleto);
        processadorDeBoletos.processa(boletos, fatura);
        assertTrue(fatura.isPago());
    }
}
