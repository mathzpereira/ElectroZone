package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Carrinho;

import java.sql.SQLException;
import java.util.ArrayList;

public class CarrinhoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCarrinho(Carrinho carrinho) {
        connectToDB();
        String sql = "INSERT INTO Carrinho (Usuario_idUsuario) values (?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, carrinho.getUsuario_idUsuario());
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
    public boolean updateCarrinho(int id, Carrinho carrinho) {
        connectToDB();
        String sql = "UPDATE Carrinho SET Usuario_idUsuario=? where idCarrinho=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, carrinho.getUsuario_idUsuario());
            pst.setInt(2, id);
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
    public boolean deleteCarrinho(int id) {
        connectToDB();
        String sql = "DELETE FROM Carrinho where idCarrinho=?";
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
    public ArrayList<Carrinho> selectCarrinho() {
        ArrayList<Carrinho> carrinhos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Carrinho";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de carrinhos: ");
            while (rs.next()) {
                Carrinho carrinhoAux = new Carrinho(rs.getInt("idCarrinho"),rs.getInt("Usuario_idUsuario"));
                System.out.println("ID Carrinho = " + carrinhoAux.getIdCarrinho());
                System.out.println("CPF Usuário = " + carrinhoAux.getUsuario_idUsuario());
                System.out.println("--------------------------------");
                carrinhos.add(carrinhoAux);
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
        return carrinhos;
    }

    public int selectCarrinhoID(int idUsuario) {
        connectToDB();
        String sql = "SELECT idCarrinho FROM Carrinho, Usuario WHERE Carrinho.Usuario_idUsuario=?";
        int idCarrinho = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();
            if(rs.next()){
                idCarrinho = rs.getInt("idCarrinho");
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
        return idCarrinho;
    }
}

