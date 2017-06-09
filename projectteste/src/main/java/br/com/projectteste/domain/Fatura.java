package br.com.projectteste.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alessandro Oliveira
 * @since 08/06/2017.
 */
public class Fatura {

    private String nomeCliente;
    private Long valor;
    private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
    private boolean isPago;

    public Fatura(String nomeCliente, Long valor) {
        this.nomeCliente = nomeCliente;
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        isPago = pago;
    }
}
