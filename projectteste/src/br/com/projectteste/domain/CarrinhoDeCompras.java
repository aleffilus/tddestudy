package br.com.projectteste.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 06/05/2017.
 */
public class CarrinhoDeCompras {

    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public CarrinhoDeCompras() {
        produtos = new ArrayList<>();
    }

    public void adiciona (Produto produtoInstance) {
        this.getProdutos().add(produtoInstance);
    }
}
