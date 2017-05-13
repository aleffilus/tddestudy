package br.com.projectteste.dao;

import br.com.projectteste.domain.NotaFiscal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro Oliveira on 10/05/2017.
 */
public class NotaFiscalDAO {

    private List<NotaFiscal> listNotas = new ArrayList<NotaFiscal>();

    public void persiste (NotaFiscal notaFiscal) {
        this.getListNotas().add(notaFiscal);
    }

    public List<NotaFiscal> getListNotas() {
        return listNotas;
    }

    public void setListNotas(List<NotaFiscal> listNotas) {
        this.listNotas = listNotas;
    }
}
