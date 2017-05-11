package br.com.projectteste.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alessandro on 09/05/2017.
 */
public class CarrinhoCompras {

    private List<Item> itens;

    public CarrinhoCompras() {
        this.itens = new ArrayList<Item>();
    }

    public void adiciona (Item item) {
        this.itens.add(item);
    }

    public List<Item> getItens () {
        return Collections.unmodifiableList(this.itens);
    }

    public double maiorValor () {
        double maior = 0;
        if (this.getItens().isEmpty()) {
            return maior;
        }

        for (Item itemIntance: this.getItens()) {
            if (maior < itemIntance.getValorUnitario()) {
                maior = itemIntance.getValorUnitario();
            }
        }

        return maior;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
