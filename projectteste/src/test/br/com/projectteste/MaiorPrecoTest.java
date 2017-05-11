package test.br.com.projectteste;

import br.com.projectteste.domain.CarrinhoCompras;
import br.com.projectteste.domain.CarrinhoComprasBuilder;
import br.com.projectteste.domain.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Alessandro on 09/05/2017.
 */
public class MaiorPrecoTest {

    private CarrinhoCompras carrinhoCompras;
    private float delta;

    @BeforeEach
    public void inicializa () {
        delta = 0.00001f;
        carrinhoCompras = new CarrinhoCompras();
    }

    @Test
    public void deveRetornarZeroSeCarrinhoVazio () {
        assertEquals(0.0, carrinhoCompras.maiorValor(), delta);
    }

    @Test
    public void deveRetornarValorDoItemSeCarrinhoComUmElemento () {
        carrinhoCompras.adiciona(new Item("Geladeira", 1, 900.00));
        assertEquals(900.00, carrinhoCompras.maiorValor(), delta);
    }

    @Test
    public void deveRetornarMarioValorSeCarrinhoContemMuitosElementos () {
        carrinhoCompras = new CarrinhoComprasBuilder().comItens(900.00, 1500.00, 750.00).cria();
        assertEquals(1500.0, carrinhoCompras.maiorValor(), delta);
    }
}
