package com.example.projetoelectrozone.models;

public class Endereco {
    private int idEndereco;
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String cep;
    private String Usuario_cpf;

    public Endereco(String rua, String bairro, int numero, String cep, String Usuario_cpf) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.Usuario_cpf = Usuario_cpf;
    }

    public Endereco(String rua, String bairro, int numero, String complemento, String cep, String Usuario_cpf) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.Usuario_cpf = Usuario_cpf;
    }

    public Endereco(int idEndereco, String rua, String bairro, int numero, String complemento, String cep, String Usuario_cpf) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.Usuario_cpf = Usuario_cpf;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUsuario_cpf() {
        return Usuario_cpf;
    }

    public void setUsuario_cpf(String usuario_cpf) {
        Usuario_cpf = usuario_cpf;
    }
}
