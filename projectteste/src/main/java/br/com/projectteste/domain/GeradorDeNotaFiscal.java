package br.com.projectteste.domain;

import br.com.projectteste.dao.NotaFiscalDAO;
import br.com.projectteste.interfaces.AcaoAposGeraNota;
import br.com.projectteste.interfaces.Relogio;
import br.com.projectteste.interfaces.Tabela;

import java.util.List;

/**
 * Created by Alessaandro Olivera on 10/05/2017.
 */
public class GeradorDeNotaFiscal {

    private List<AcaoAposGeraNota> acoes = null;
    private Relogio relogio = null;
    private Tabela tabela = null;

    public GeradorDeNotaFiscal (List<AcaoAposGeraNota> acoes) {
        this(acoes, new RelogioDoSistema());
    }

    public GeradorDeNotaFiscal (List<AcaoAposGeraNota> acoes, Relogio relogio) {
        this.acoes = acoes;
        this.relogio = relogio;
    }

    public GeradorDeNotaFiscal (List<AcaoAposGeraNota> acoes, Relogio relogio, Tabela tabela) {
        this.acoes = acoes;
        this.relogio = relogio;
        this.tabela = tabela;
    }

    public GeradorDeNotaFiscal(NotaFiscalDAO notaFiscalDAO, SAP sap) {
    }

    public NotaFiscal gerar (Pedido pedido) {
        NotaFiscal notaFiscal = new NotaFiscal(pedido.getCliente(),pedido.getValorTotal() * tabela.paraValor(pedido.getValorTotal()), relogio.hoje());

        if (null != acoes) {
            for (AcaoAposGeraNota acaoAposGeraNota : acoes) {
                acaoAposGeraNota.executa(notaFiscal);
            }
        }

        return notaFiscal;
    }

}
