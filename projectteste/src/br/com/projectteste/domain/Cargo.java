package br.com.projectteste.domain;

/**
 * Created by Alessandro on 08/05/2017.
 */
public enum Cargo {
    DESENVOLVEDOR(new DezOuVindePorCento()),
    DBA(new QuizaOuVinteCincoPorCento()),
    TESTADOR(new QuizaOuVinteCincoPorCento());

    private final RegraDeCalculo regraDeCalculo;

    Cargo (RegraDeCalculo regraDeCalculo) {
        this.regraDeCalculo = regraDeCalculo;
    }

    public RegraDeCalculo getRegraDeCalculo() {
        return regraDeCalculo;
    }
}
