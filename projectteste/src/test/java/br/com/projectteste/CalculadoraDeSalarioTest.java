package br.com.projectteste;

import br.com.projectteste.domain.CalculadoraDeSalario;
import br.com.projectteste.domain.Cargo;
import br.com.projectteste.domain.Funcionario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Created by Alessandro on 08/05/2017.
 */
public class CalculadoraDeSalarioTest {

    private final CalculadoraDeSalario calculadoraDeSalario = new CalculadoraDeSalario();
    private final float delta = 0.00001f;

    @Test
    public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite () {
        Funcionario desenvolvedor = new Funcionario("Mauricio", 1500.0, Cargo.DESENVOLVEDOR);

        double salario = calculadoraDeSalario.calculaSalario(desenvolvedor);

        assertEquals(1500.0 * 0.9, salario, delta);
    }

    @Test
    public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite () {
        Funcionario desenvolvedor = new Funcionario("Alessandro", 4000.0, Cargo.DESENVOLVEDOR);

        double salario = calculadoraDeSalario.calculaSalario(desenvolvedor);

        assertEquals(4000* 0.8, salario, delta);
    }

    @Test
    public void deveCalcularSalarioParaDBAsComSalarioAbaixoDoLimite () {
        Funcionario dba = new Funcionario("Alessandro", 500.0, Cargo.DBA);

        double salario = calculadoraDeSalario.calculaSalario(dba);

        assertEquals(500.0 * 0.85, salario, delta);
    }
}