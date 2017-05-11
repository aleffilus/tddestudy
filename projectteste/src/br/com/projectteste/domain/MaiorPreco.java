package br.com.projectteste.domain;

/**
 * Created by Alessandro on 09/05/2017.
 */
public class MaiorPreco {

    public double encontra(CarrinhoCompras carrinhoCompras) {
        double maior = 0;
        if (carrinhoCompras.getItens().isEmpty()) {
            return maior;
        }

        for (Item itemIntance: carrinhoCompras.getItens()) {
            if (maior < itemIntance.getValorUnitario()) {
                maior = itemIntance.getValorUnitario();
            }
        }

        return maior;
    }
}
