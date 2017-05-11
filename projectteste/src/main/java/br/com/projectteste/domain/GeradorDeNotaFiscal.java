package br.com.projectteste.domain;

import br.com.projectteste.dao.NotaFiscalDAO;

import java.util.Calendar;

/**
 * Created by Alessaandro Olivera on 10/05/2017.
 */
public class GeradorDeNotaFiscal {

    private NotaFiscalDAO notaFiscalDAO;
    private final SAP sap;

    public GeradorDeNotaFiscal (NotaFiscalDAO notaFiscalDAO, SAP sap) {
        this.notaFiscalDAO = notaFiscalDAO;
        this.sap = sap;
    }

    public NotaFiscal gerar (Pedido pedido) {
        NotaFiscal notaFiscal = new NotaFiscal(pedido.getCliente(),pedido.getValorTotal() * 0.94, Calendar.getInstance());

        notaFiscalDAO.persiste(notaFiscal);
        sap.envia(notaFiscal);

        return notaFiscal;
    }

}
