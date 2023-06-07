package com.example.projetoelectrozone.models;

public class Imagem {
    private int idImagem;
    private String nome;
    private String dados_imagem;
    private int Produto_idProduto;

    public Imagem(int idImagem, String nome, String dados_imagem, int produto_idProduto) {
        this.idImagem = idImagem;
        this.nome = nome;
        this.dados_imagem = dados_imagem;
        Produto_idProduto = produto_idProduto;
    }

}
