package br.com.projectteste.domain;

import br.com.projectteste.interfaces.Relogio;

import java.util.Calendar;

/**
 * @author Alessandro Oliveira
 * @since 19/05/2017.
 */
public class RelogioDoSistema implements Relogio {
    public Calendar hoje () {
        return Calendar.getInstance();
    }
}
