package br.com.projectteste.domain;

/**
 * @author Alessandro Oliveira
 * @since 08/06/2017.
 */
public class Boleto {

    private Long valor;

    public Boleto(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}
