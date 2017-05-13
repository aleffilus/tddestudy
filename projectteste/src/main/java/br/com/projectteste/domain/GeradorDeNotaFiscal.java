package br.com.projectteste.domain;

import br.com.projectteste.dao.NotaFiscalDAO;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Alessaandro Olivera on 10/05/2017.
 */
public class GeradorDeNotaFiscal {

    private List<AcaoAposGeraNota> acoes = null;

    public GeradorDeNotaFiscal (List<AcaoAposGeraNota> acoes) {
        this.acoes = acoes;
    }

    public GeradorDeNotaFiscal(NotaFiscalDAO notaFiscalDAO, SAP sap) {
    }

    public NotaFiscal gerar (Pedido pedido) {
        NotaFiscal notaFiscal = new NotaFiscal(pedido.getCliente(),pedido.getValorTotal() * 0.94, Calendar.getInstance());

        if (null != acoes) {
            for (AcaoAposGeraNota acaoAposGeraNota : acoes) {
                acaoAposGeraNota.executa(notaFiscal);
            }
        }

        return notaFiscal;
    }

}
