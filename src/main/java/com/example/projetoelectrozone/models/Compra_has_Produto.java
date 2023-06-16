package com.example.projetoelectrozone.models;

public class Compra_has_Produto {

    private int Compra_idCompra;
    private int Produto_idProduto;

    public Compra_has_Produto(int compra_idCompra, int produto_idProduto) {
        Compra_idCompra = compra_idCompra;
        Produto_idProduto = produto_idProduto;
    }

    public int getCompra_idCompra() {
        return Compra_idCompra;
    }

    public void setCompra_idCompra(int compra_idCompra) {
        Compra_idCompra = compra_idCompra;
    }

    public int getProduto_idProduto() {
        return Produto_idProduto;
    }

    public void setProduto_idProduto(int produto_idProduto) {
        Produto_idProduto = produto_idProduto;
    }
}
