package com.example.projetoelectrozone.models;

public class Usuario {
    private int idUsuario;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private Carrinho carrinho;
    private Endereco endereco;
    private static int id = 0;

    public Usuario(String cpf, String nome, String email, String senha) {
        id++;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.carrinho = new Carrinho(id);
    }

    public Usuario(int idUsuario, String cpf, String nome, String email, String senha) {
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
