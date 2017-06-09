package br.com.projectteste.domain;

import br.com.projectteste.enums.MeioDePagamento;

import java.util.List;

/**
 * @author Alessandro Oliveira
 * @since 08/06/2017.
 */
public class ProcessadorDeBoletos {

    public  void processa (List<Boleto> boletos, Fatura fatura) {
        Long valorTotal = 0L;

        for (Boleto boletoInstance : boletos) {
            Pagamento pagamento = new Pagamento(boletoInstance.getValor(), MeioDePagamento.BOLETO);
            fatura.getPagamentos().add(pagamento);

            valorTotal += boletoInstance.getValor();
        }

        if (valorTotal >= fatura.getValor()) {
            fatura.setPago(true);
        }

    }
}
