package com.example.projetoelectrozone.models;

public class Carrinho {
    private int idCarrinho;
    private int Usuario_idUsuario;

    public Carrinho(int usuario_idUsuario) {
        Usuario_idUsuario = usuario_idUsuario;
    }

    public Carrinho(int idCarrinho, int usuario_idUsuario) {
        this.idCarrinho = idCarrinho;
        Usuario_idUsuario = usuario_idUsuario;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int usuario_idUsuario) {
        Usuario_idUsuario = usuario_idUsuario;
    }
}
