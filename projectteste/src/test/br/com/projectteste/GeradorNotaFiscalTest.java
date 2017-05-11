package test.br.com.projectteste;

import br.com.projectteste.domain.CarrinhoCompras;
import br.com.projectteste.domain.GeradorDeNotaFiscal;
import br.com.projectteste.domain.NotaFiscal;
import br.com.projectteste.domain.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        geradorNotaFiscal = new GeradorDeNotaFiscal();
    }

    @Test
    public void deveGerarNotaFiscalComValorDeImpostoDescontado() {
        Pedido pedido = new Pedido("Alessandro", 1000, 1);

        NotaFiscal notaFiscal = geradorNotaFiscal.gerar(pedido);

        assertEquals(1000 * 0.94, notaFiscal.getValor(), delta);
    }

}
