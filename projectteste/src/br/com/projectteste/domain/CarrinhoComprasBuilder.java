package br.com.projectteste.domain;

/**
 * Created by Alessandro on 09/05/2017.
 */
public class CarrinhoComprasBuilder {

    public CarrinhoCompras carrinhoCompras;

    public CarrinhoComprasBuilder() {
        this.carrinhoCompras = new CarrinhoCompras();
    }

    public CarrinhoComprasBuilder comItens (double... valores) {
        for (double valorInstance : valores) {
            carrinhoCompras.adiciona(new Item("Item", 1, valorInstance));
        }
        return this;
    }

    public CarrinhoCompras cria () {
        return carrinhoCompras;
    }
}
