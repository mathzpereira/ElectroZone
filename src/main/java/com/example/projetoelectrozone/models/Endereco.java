package com.example.projetoelectrozone.models;

public class Endereco {
    private int idEndereco;
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String cep;

    public Endereco(int idEndereco, String rua, String bairro, int numero, String cep) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }
}
