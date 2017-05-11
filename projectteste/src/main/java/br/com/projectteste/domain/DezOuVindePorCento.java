package br.com.projectteste.domain;

/**
 * Created by Alessandro on 10/05/2017.
 */
public class DezOuVindePorCento extends RegraDeCalculo {
    @Override
    protected int limite() {
        return 3000;
    }

    @Override
    protected double porcentagemAcimaDoLimite() {
        return 0.8;
    }

    @Override
    protected double porcentagemBase() {
        return 0.9;
    }
}
