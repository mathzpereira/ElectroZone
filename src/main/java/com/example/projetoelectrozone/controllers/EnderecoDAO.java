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
        String sql = "INSERT INTO Endereco (rua, bairro, numero, complemento, cep, Usuario_cpf) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setInt(3, endereco.getNumero());
            pst.setString(4, endereco.getComplemento());
            pst.setString(5, endereco.getCep());
            pst.setString(6,endereco.getUsuario_cpf());
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
    //UPDATE
    public boolean updateEndereco(int id, Endereco endereco) {
        connectToDB();
        String sql = "UPDATE Endereco SET rua=?, bairro=?, numero=?, complemento=?, cep=? where idEndereco=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setInt(3, endereco.getNumero());
            pst.setString(4, endereco.getComplemento());
            pst.setString(5, endereco.getCep());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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
    //DELETE
    public boolean deleteEndereco(int id) {
        connectToDB();
        String sql = "DELETE FROM Endereco where idEndereco=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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
    //SELECT
    public ArrayList<Endereco> selectEndereco() {
        ArrayList<Endereco> enderecos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Endereco";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de enderecos: ");
            while (rs.next()) {
                Endereco enderecoAux = new Endereco(rs.getInt("idEndereco"),rs.getString("rua"),rs.getString("bairro"),rs.getInt("numero"),rs.getString("complemento"),rs.getString("cep"),rs.getString("Usuario_cpf"));
                System.out.println("ID Endereço = " + enderecoAux.getIdEndereco());
                System.out.println("Rua = " + enderecoAux.getRua());
                System.out.println("Bairro = " + enderecoAux.getBairro());
                System.out.println("Número = " + enderecoAux.getNumero());
                System.out.println("Complemento = " + enderecoAux.getComplemento());
                System.out.println("CEP = " + enderecoAux.getCep());
                System.out.println("--------------------------------");
                enderecos.add(enderecoAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return enderecos;
    }
}

