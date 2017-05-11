package br.com.projectteste.domain;

/**
 * Created by Alessandro on 06/05/2017.
 */
public class Produto {

    private  String nome;
    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (Float.compare(produto.valor, valor) != 0) return false;
        return nome.equals(produto.nome);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + (valor != +0.0f ? Float.floatToIntBits(valor) : 0);
        return result;
    }
}
