package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Imagem;

import java.sql.SQLException;
import java.util.ArrayList;

public class ImagemDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertImagem(Imagem imagem) {
        connectToDB();
        String sql = "INSERT INTO Imagem (nome, dados_imagem, Produto_idProduto) values (?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, imagem.getNome());
            pst.setBinaryStream(2, imagem.getDados_imagem());
            pst.setInt(3, imagem.getProduto_idProduto());
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
    public boolean updateImagem(int id, Imagem imagem) {
        connectToDB();
        String sql = "UPDATE Imagem SET nome=?, dados_imagem=?, Produto_idProduto=? where idImagem=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, imagem.getNome());
            pst.setBinaryStream(2, imagem.getDados_imagem());
            pst.setInt(3, imagem.getProduto_idProduto());
            pst.setInt(4, id);
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
    public boolean deleteImagem(int id) {
        connectToDB();
        String sql = "DELETE FROM Imagem where idImagem=?";
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
    public ArrayList<Imagem> selectImagem() {
        ArrayList<Imagem> imagems = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Imagem";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de imagens: ");
            while (rs.next()) {
                Imagem imagemAux = new Imagem(rs.getString("nome"),rs.getBinaryStream("dados_imagem"),rs.getInt("Produto_idProduto"));
                System.out.println("ID Imagem = " + imagemAux.getIdImagem());
                System.out.println("Nome = " + imagemAux.getNome());
                System.out.println("Dados = " + imagemAux.getDados_imagem());
                System.out.println("ID Produto = " + imagemAux.getProduto_idProduto());
                System.out.println("--------------------------------");
                imagems.add(imagemAux);
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
        return imagems;
    }
}

