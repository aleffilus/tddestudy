package br.com.projectteste;

import br.com.projectteste.dao.NotaFiscalDAO;
import br.com.projectteste.domain.*;
import br.com.projectteste.interfaces.AcaoAposGeraNota;
import br.com.projectteste.interfaces.Tabela;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Alessandro Oliveira on 10/05/2017.
 */
public class GeradorNotaFiscalTest {

    private GeradorDeNotaFiscal geradorNotaFiscal;
    private float delta;
    private List<AcaoAposGeraNota> acoes;
    private AcaoAposGeraNota acaoAposGeraNota1;
    private AcaoAposGeraNota acaoAposGeraNota2;
    private Tabela tabela;

    @BeforeEach
    public void inicializa () {
        delta = 0.00001f;
        acaoAposGeraNota1 = Mockito.mock(AcaoAposGeraNota.class);
        acaoAposGeraNota2 = Mockito.mock(AcaoAposGeraNota.class);
        acoes = Arrays.asList(acaoAposGeraNota1, acaoAposGeraNota2);
        // Mockando uma tabela, que ainda nem existe
        tabela = Mockito.mock(Tabela.class);

        geradorNotaFiscal = new GeradorDeNotaFiscal(acoes, new RelogioDoSistema(), tabela);
    }

    @Test
    public void deveGerarNotaFiscalComValorDeImpostoDescontado() {
        Pedido pedido = new Pedido("Alessandro", 1000, 1);

        NotaFiscal notaFiscal = geradorNotaFiscal.gerar(pedido);

        assertEquals(1000 * 0.94, notaFiscal.getValor(), delta);
    }

    @Test
    public void devePersistirNotaFiscalGerada () {
        // Criando o
        NotaFiscalDAO notaFiscalDAO = Mockito.mock(NotaFiscalDAO.class);
        SAP sap = Mockito.mock(SAP.class);

        geradorNotaFiscal = new GeradorDeNotaFiscal(notaFiscalDAO, sap);

        Pedido pedido = new Pedido("Alessandro", 1000, 1);

        NotaFiscal notaFiscal = geradorNotaFiscal.gerar(pedido);

        // Verficando que o mêtodo foi invocado
        Mockito.verify(notaFiscalDAO).persiste(notaFiscal);
    }

    @Test
    public void deveInvocarAcoesPosteriores () {
        Pedido pedido = new Pedido("Alessandro", 1000, 1);

        NotaFiscal notaFiscal = geradorNotaFiscal.gerar(pedido);

        Mockito.verify(acaoAposGeraNota1).executa(notaFiscal);
        Mockito.verify(acaoAposGeraNota2).executa(notaFiscal);
    }

    @Test
    public void deveConsultarATabelaParaCalcularValor () {
        // Definindo o futuro comportamento "paraVaalor"
        // que deve retornar 0.2 caso o valor seja 1000.0
        Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.2);

        List<AcaoAposGeraNota> nenhumaAcao = Collections.emptyList();
        Pedido pedido = new Pedido("Alessandro", 1000, 1);

        NotaFiscal notaFiscal = geradorNotaFiscal.gerar(pedido);

        // Garantindo que a tabela foi consultada
        Mockito.verify(tabela).paraValor(1000.0);
        assertEquals(1000 * 0.2, notaFiscal.getValor(), delta);
    }
}
