package com.example.projetoelectrozone.models;

public class Carrinho {
    private int idCarrinho;
    private String Usuario_cpf;

    public Carrinho(String usuario_cpf) {
        Usuario_cpf = usuario_cpf;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getUsuario_cpf() {
        return Usuario_cpf;
    }

    public void setUsuario_cpf(String usuario_cpf) {
        Usuario_cpf = usuario_cpf;
    }
}
