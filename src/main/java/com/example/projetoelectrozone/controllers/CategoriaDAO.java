package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Categoria;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCategoria(Categoria categoria) {
        connectToDB();
        String sql = "INSERT INTO Categoria (nome) values(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, categoria.getNome());
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
    public boolean updateCategoria(int id, Categoria categoria) {
        connectToDB();
        String sql = "UPDATE Categoria SET nome=? where idCategoria=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, categoria.getNome());
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
    public boolean deleteCategoria(int id) {
        connectToDB();
        String sql = "DELETE FROM Categoria where idCategoria=?";
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
    public ArrayList<Categoria> selectCategoria() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Categoria";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de categorias: ");
            while (rs.next()) {
                Categoria categoriaAux = new Categoria(rs.getInt("idCategoria"),rs.getString("nome"));
                System.out.println("ID = " + categoriaAux.getIdCategoria());
                System.out.println("Nome = " + categoriaAux.getNome());
                System.out.println("--------------------------------");
                categorias.add(categoriaAux);
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
        return categorias;
    }
}

