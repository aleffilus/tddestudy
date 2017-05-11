package br.com.projectteste.domain;

/**
 * Created by Alessandro on 08/05/2017.
 */
public class CalculadoraDeSalario {

    public double calculaSalario(Funcionario funcionario) {
        return funcionario.getCargo().getRegraDeCalculo().calcula(funcionario);
    }
}
