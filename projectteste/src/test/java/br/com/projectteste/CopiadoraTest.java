package br.com.projectteste;

import br.com.projectteste.domain.Copiadora;
import br.com.projectteste.domain.EscritorPelaSerial;
import br.com.projectteste.domain.LeitorDeXML;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author Alessandro Oliveira
 * @since 13/05/2017.
 */
public class CopiadoraTest {

    @Test
    public void deveLerEEnviarOCOnteudoLido () {
        EscritorPelaSerial escritorPelaSerial = Mockito.mock(EscritorPelaSerial.class);
        LeitorDeXML leitorDeXML = Mockito.mock(LeitorDeXML.class);

        Mockito.when(leitorDeXML.temCaracteres()).thenReturn(true, false);
        Mockito.when(leitorDeXML.leCaracteres()).thenReturn("Alessandro");

        Copiadora copiadora = new Copiadora(leitorDeXML, escritorPelaSerial);

        copiadora.copiar();

        Mockito.verify(escritorPelaSerial).escreve("Alessandro");
    }
}
