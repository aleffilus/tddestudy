package test.br.com.projectteste;

import br.com.projectteste.domain.ConversorDeNumeroRomano;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Created by Alessandro on 07/05/2017.
 */
public class ConversorDeNumeroRomanoTest {

    final ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();

    @Test
    public void deveEntenderOSimboloI () {
        int numero = romano.converte("I");
        assertEquals(1, numero);
    }

    @Test
    public void deveEntenderOSimboloV () {
        int numero = romano.converte("V");
        assertEquals(5, numero);
    }

    @Test
    public void deveEntenderDoisSImbolosComoII () {
        int numero = romano.converte("II");
        assertEquals(2, numero);
    }

    @Test
    public void deveEntenerQuatroSimbolosADoisComoXXII () {
        int numero = romano.converte("XXII");
        assertEquals(22, numero);
    }

    @Test
    public void deveEntenerNumeroComoIX() {
        int numero = romano.converte("IX");
        assertEquals(9, numero);
    }

    @Test
    public void deveEntenderNumerosComplexosComoXXIV () {
        int numero = romano.converte("XXIV");
        assertEquals(24, numero);
    }
}
