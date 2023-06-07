package com.example.projetoelectrozone.models;

public class Carrinho {
    private int idCarrinho;
    private int Usuario_cpf;

    public Carrinho(int usuario_cpf) {
        Usuario_cpf = usuario_cpf;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getUsuario_cpf() {
        return Usuario_cpf;
    }

    public void setUsuario_cpf(int usuario_cpf) {
        Usuario_cpf = usuario_cpf;
    }
}
