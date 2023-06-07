package com.example.projetoelectrozone.models;

public class Imagem {
    private int idImagem;
    private String nome;
    private String dados_imagem;
    private int Produto_idProduto;

    public Imagem(String nome, String dados_imagem, int produto_idProduto) {
        this.nome = nome;
        this.dados_imagem = dados_imagem;
        Produto_idProduto = produto_idProduto;
    }

}
