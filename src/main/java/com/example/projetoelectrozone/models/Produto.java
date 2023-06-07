package com.example.projetoelectrozone.models;

public class Produto {
    private int idProduto;
    private String nome;
    private double valor;
    private int qtd_disponivel;
    private int categoria_idCategoria;

    public Produto(String nome, double valor, int qtd_disponivel, int categoria_idCategoria) {
        this.nome = nome;
        this.valor = valor;
        this.qtd_disponivel = qtd_disponivel;
        this.categoria_idCategoria = categoria_idCategoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd_disponivel() {
        return qtd_disponivel;
    }

    public void setQtd_disponivel(int qtd_disponivel) {
        this.qtd_disponivel = qtd_disponivel;
    }

    public int getCategoria_idCategoria() {
        return categoria_idCategoria;
    }

    public void setCategoria_idCategoria(int categoria_idCategoria) {
        this.categoria_idCategoria = categoria_idCategoria;
    }
}
