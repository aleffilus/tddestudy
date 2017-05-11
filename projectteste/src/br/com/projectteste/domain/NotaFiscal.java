package br.com.projectteste.domain;

import java.util.Calendar;

/**
 * Created by Alessandro Oliveira on 10/05/2017.
 */
public class NotaFiscal {

    private  String cliente;
    private double valor;
    private Calendar data;

    public NotaFiscal(String cliente, double valor, Calendar data) {
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
