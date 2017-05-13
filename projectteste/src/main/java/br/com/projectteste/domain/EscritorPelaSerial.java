package br.com.projectteste.domain;

/**
 * @author Alessandro Oliveira
 * @since 13/05/2017.
 */
public class EscritorPelaSerial {

    private String escrita = "";

    public void escreve(String escrever) {
        this.escrita += escrever;
    }

    public String getEscrita() {
        return escrita;
    }

    public void setEscrita(String escrita) {
        this.escrita = escrita;
    }
}
