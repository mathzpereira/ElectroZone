package com.example.projetoelectrozone.models;

public class Compra {
    private int idCompra;
    private double valor;
    private String data;
    private int Usuario_idUsuario;

    public Compra(double valor, String data, int usuario_idUsuario) {
        this.valor = valor;
        this.data = data;
        Usuario_idUsuario = usuario_idUsuario;
    }

    public Compra(int idCompra, double valor, String data, int usuario_idUsuario) {
        this.idCompra = idCompra;
        this.valor = valor;
        this.data = data;
        Usuario_idUsuario = usuario_idUsuario;
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

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int usuario_idUsuario) {
        Usuario_idUsuario = usuario_idUsuario;
    }
}
