package com.example.projetoelectrozone.models;

public class Compra {
    private int idCompra;
    private double valor;
    private String data;
    private int Usuario_cpf;

    public Compra(double valor, String data, int usuario_cpf) {
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

    public int getUsuario_cpf() {
        return Usuario_cpf;
    }

    public void setUsuario_cpf(int usuario_cpf) {
        Usuario_cpf = usuario_cpf;
    }

}
