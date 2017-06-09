package br.com.projectteste.interfaces;

import br.com.projectteste.domain.NotaFiscal;

/**
 * @author Alessandro Oliveira
 * @since 13/05/2017.
 */
public interface AcaoAposGeraNota {
    void executa(NotaFiscal notaFiscal);
}
