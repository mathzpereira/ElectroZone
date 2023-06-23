package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Endereco;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertEndereco(Endereco endereco) {
        connectToDB();
        String sql = "INSERT INTO Endereco (rua, bairro, numero, cep, Usuario_idUsuario) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setInt(3, endereco.getNumero());
            pst.setString(4, endereco.getCep());
            pst.setInt(5,endereco.getUsuario_idUsuario());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}

