package test.br.com.projectteste;

import br.com.projectteste.domain.CarrinhoDeCompras;
import br.com.projectteste.domain.MaiorEMenor;
import br.com.projectteste.domain.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Alessandro on 06/05/2017.
 */
public class TestaMaiorEMenor {

    @Test
    public void ordemDecrescente() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adiciona(new Produto("Geladeira", 450.0f));
        carrinho.adiciona(new Produto("Liquidificador", 250.0f));
        carrinho.adiciona(new Produto("Jogo de pratos", 70.0f));
        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinho);

        assertEquals("Jogo de pratos",
                algoritmo.getMenor().getNome());
        assertEquals("Geladeira",
                algoritmo.getMaior().getNome());
    }

    @Test
    public  void apenasUmProduto () {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        Produto produto = new Produto("Geladeira", 150.0f);
        carrinhoDeCompras.adiciona(produto);

        MaiorEMenor algoritomo = new MaiorEMenor();
        algoritomo.encontra(carrinhoDeCompras);

        assertEquals(produto, algoritomo.getMenor());
        assertEquals(produto, algoritomo.getMaior());
    }
}
