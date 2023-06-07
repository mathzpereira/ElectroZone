package com.example.projetoelectrozone.models;

public class Usuario {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private int Endereco_idEndereco;

    public Usuario(String cpf, String nome, String email, String senha, int endereco_idEndereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        Endereco_idEndereco = endereco_idEndereco;
    }
}
