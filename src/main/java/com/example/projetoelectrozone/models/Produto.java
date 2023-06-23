package com.example.projetoelectrozone.models;

public class Produto {
    private int idProduto;
    private String nome;
    private double valor;
    private int qtd_disponivel;
    private String categoria;

    // Construtores
    public Produto(String nome, double valor, int qtd_disponivel, String categoria) {
        this.nome = nome;
        this.valor = valor;
        this.qtd_disponivel = qtd_disponivel;
        this.categoria = categoria;
    }

    public Produto(int idProduto, String nome, double valor, int qtd_disponivel, String categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.qtd_disponivel = qtd_disponivel;
        this.categoria = categoria;
    }

    public Produto(int idProduto, String nome, double valor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
    }

    // Getters e setters
    public int getIdProduto() {
        return idProduto;
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

    public int getQtd_disponivel() {
        return qtd_disponivel;
    }

    public String getCategoria() {
        return categoria;
    }
}
