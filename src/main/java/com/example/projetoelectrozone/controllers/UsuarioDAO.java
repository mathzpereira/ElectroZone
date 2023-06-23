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
        String sql = "INSERT INTO Usuario (cpf,nome,email,senha,cargo,saldo) values(?,?,?,?,?,0)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getCpf());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            pst.setString(5, usuario.getCargo());
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
        String sql = "UPDATE Usuario SET cpf=?, nome=?, email=?, senha=?, cargo=? where idUsuario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getCpf());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            pst.setString(5, usuario.getCargo());
            pst.setInt(6, id);
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
    public boolean deleteUsuario(String cpf) {
        connectToDB();
        String sql = "DELETE FROM Usuario where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
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
                Usuario usuarioAux = new Usuario(rs.getInt("idUsuario"),rs.getString("cpf"),rs.getString("nome"),rs.getString("email"),rs.getString("senha"),rs.getString("cargo"),rs.getDouble("saldo"));
                System.out.println("ID Usuário: " + usuarioAux.getIdUsuario());
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

    public Usuario selectUsuarioLogin(String email, String senha) {
        connectToDB();
        String sql = "SELECT * FROM Usuario WHERE email=? AND senha=?";
        Usuario usuario = null;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, senha);
            rs = pst.executeQuery();
            if(rs != null && rs.next()){
                usuario = new Usuario(rs.getInt("idUsuario"),rs.getString("cpf"),rs.getString("nome"),rs.getString("email"),rs.getString("senha"),rs.getString("cargo"),rs.getDouble("saldo"));
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return usuario;
    }

    public int selectUsuarioID(String email, String senha) {
        connectToDB();
        String sql = "SELECT idUsuario FROM Usuario WHERE email=? AND senha=?";
        int id = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, senha);
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt("idUsuario");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return id;
    }
    public void depositar(int idUsuario, double valor) {
        connectToDB();
        String sql = "UPDATE Usuario SET saldo = saldo + ? where idUsuario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setInt(2, idUsuario);
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
    }

    public void removerSaldo(int idUsuario, double valorCompra) {
        connectToDB();
        String sql = "UPDATE Usuario SET saldo = saldo - ? where idUsuario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, valorCompra);
            pst.setInt(2, idUsuario);
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
    }

}

