package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertUsuario(Usuario usuario) {
        connectToDB();
        String sql = "INSERT INTO Usuario (cpf,nome,email,senha) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getCpf());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
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
    public boolean updateUsuario(int id, Usuario usuario) {
        connectToDB();
        String sql = "UPDATE Usuario SET cpf=?, nome=?, email=?, senha=?, Endereco=id_Endereco=? where idUsuario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getCpf());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
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
    public boolean deleteUsuario(int id) {
        connectToDB();
        String sql = "DELETE FROM Usuario where idUsuario=?";
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
    public ArrayList<Usuario> selectUsuario() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Usuario";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de usuarios: ");
            while (rs.next()) {
                Usuario usuarioAux = new Usuario(rs.getString("cpf"),rs.getString("nome"),rs.getString("email"),rs.getString("senha"));
                System.out.println("CPF = " + usuarioAux.getCpf());
                System.out.println("Nome = " + usuarioAux.getNome());
                System.out.println("E-mail = " + usuarioAux.getEmail());
                System.out.println("Senha = " + usuarioAux.getSenha());
                System.out.println("--------------------------------");
                usuarios.add(usuarioAux);
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
        return usuarios;
    }
}

