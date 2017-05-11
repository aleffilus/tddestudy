package br.com.projectteste.domain;

/**
 * Created by Alessandro on 10/05/2017.
 */
public class QuizaOuVinteCincoPorCento extends RegraDeCalculo {
    @Override
    protected int limite() {
        return 2500;
    }

    @Override
    protected double porcentagemAcimaDoLimite() {
        return 0.75;
    }

    @Override
    protected double porcentagemBase() {
        return 0.85;
    }
}
