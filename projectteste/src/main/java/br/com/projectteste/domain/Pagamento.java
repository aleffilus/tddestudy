package br.com.projectteste.domain;

import br.com.projectteste.enums.MeioDePagamento;

/**
 * @author Alessandro Oliveira
 * @since 08/06/2017.
 */
public class Pagamento {

    private Long valor;
    private MeioDePagamento meioDePagamento;

    public Pagamento(Long valor, MeioDePagamento meioDePagamento) {
        this.valor = valor;
        this.meioDePagamento = meioDePagamento;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public MeioDePagamento getMeioDePagamento() {
        return meioDePagamento;
    }

    public void setMeioDePagamento(MeioDePagamento meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }
}
