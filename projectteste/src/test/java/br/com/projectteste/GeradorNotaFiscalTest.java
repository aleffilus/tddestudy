package br.com.projectteste;

import br.com.projectteste.dao.NotaFiscalDAO;
import br.com.projectteste.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Alessandro Oliveira on 10/05/2017.
 */
public class GeradorNotaFiscalTest {

    private GeradorDeNotaFiscal geradorNotaFiscal;
    private float delta;

    @BeforeEach
    public void inicializa () {
        delta = 0.00001f;
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

}
