package br.com.projectteste.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alessandro on 07/05/2017.
 */
public class ConversorDeNumeroRomano {

    private static Map<String, Integer> tabela = new HashMap<String, Integer>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public int converte (String numeroEmRomano) {
        int acumulador = 0;
        int ultimoVizinhoDaDireita = 0;
        for(int i = numeroEmRomano.length() - 1; i >= 0; i--) {
            // Pega o inteiro referente ao simbolo atual
            int atual = tabela.get(String.valueOf(numeroEmRomano.charAt(i)));

            //se o anterior o proximo for menor, miltiplicamos por -1 para tornar ele negativo
            int mulplicador = 1;
            if (atual < ultimoVizinhoDaDireita) {
                mulplicador = -1;
            }

            acumulador += atual * mulplicador;

            // atualiza o vizinho da direta
            ultimoVizinhoDaDireita = atual;
        }
        return acumulador;
    }
}
