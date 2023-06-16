package com.example.projetoelectrozone.models;

import java.io.FileInputStream;
import java.io.InputStream;

public class Imagem {
    private int idImagem;
    private String nome;
    private FileInputStream dados_imagem;
    private int Produto_idProduto;

    public Imagem(String nome, FileInputStream dados_imagem, int produto_idProduto) {
        this.nome = nome;
        this.dados_imagem = dados_imagem;
        Produto_idProduto = produto_idProduto;
    }

    public Imagem(String nome, InputStream dados_imagem, int produto_idProduto) {
        this.nome = nome;
        this.dados_imagem = (FileInputStream) dados_imagem;
        Produto_idProduto = produto_idProduto;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FileInputStream getDados_imagem() {
        return dados_imagem;
    }

    public void setDados_imagem(FileInputStream dados_imagem) {
        this.dados_imagem = dados_imagem;
    }

    public int getProduto_idProduto() {
        return Produto_idProduto;
    }

    public void setProduto_idProduto(int produto_idProduto) {
        Produto_idProduto = produto_idProduto;
    }
}
