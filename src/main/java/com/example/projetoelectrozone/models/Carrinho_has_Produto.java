package com.example.projetoelectrozone.models;

public class Carrinho_has_Produto {

    private int Carrinho_idCarrinho;
    private int Produto_idProduto;

    public Carrinho_has_Produto(int carrinho_idCarrinho, int produto_idProduto) {
        Carrinho_idCarrinho = carrinho_idCarrinho;
        Produto_idProduto = produto_idProduto;
    }

    public int getCarrinho_idCarrinho() {
        return Carrinho_idCarrinho;
    }

    public void setCarrinho_idCarrinho(int carrinho_idCarrinho) {
        Carrinho_idCarrinho = carrinho_idCarrinho;
    }

    public int getProduto_idProduto() {
        return Produto_idProduto;
    }

    public void setProduto_idProduto(int produto_idProduto) {
        Produto_idProduto = produto_idProduto;
    }
}
