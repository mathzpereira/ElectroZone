package com.example.projetoelectrozone.models;

public class Compra {
    private int idCompra;
    private double valor;
    private String data;
    private String Usuario_cpf;

    public Compra(double valor, String data, String usuario_cpf) {
        this.valor = valor;
        this.data = data;
        Usuario_cpf = usuario_cpf;
    }

    public Compra(int idCompra, double valor, String data, String usuario_cpf) {
        this.idCompra = idCompra;
        this.valor = valor;
        this.data = data;
        Usuario_cpf = usuario_cpf;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUsuario_cpf() {
        return Usuario_cpf;
    }

    public void setUsuario_cpf(String usuario_cpf) {
        Usuario_cpf = usuario_cpf;
    }
}
