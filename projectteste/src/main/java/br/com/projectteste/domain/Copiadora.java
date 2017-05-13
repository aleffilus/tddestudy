package br.com.projectteste.domain;

/**
 * @author Alessandro Oliveira
 * @since 13/05/2017.
 */
public class Copiadora {

    private LeitorDeXML leitorDeXML;
    private EscritorPelaSerial escritorPelaSerial;

    public Copiadora (LeitorDeXML leitorDeXML, EscritorPelaSerial escritorPelaSerial) {
        this.leitorDeXML = leitorDeXML;
        this.escritorPelaSerial = escritorPelaSerial;
    }

    public void copiar() {
        while (leitorDeXML.temCaracteres()) {
            escritorPelaSerial.escreve(leitorDeXML.leCaracteres());
        }
    }
}
