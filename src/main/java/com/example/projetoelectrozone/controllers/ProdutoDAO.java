package com.example.projetoelectrozone.controllers;
import com.example.projetoelectrozone.models.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertProduto(Produto produto) {
        connectToDB();
        // Insere as informações do produto na tabela
        String sql = "INSERT INTO Produto (nome, valor, qtd_disponivel, Categoria) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getValor());
            pst.setInt(3, produto.getQtd_disponivel());
            pst.setString(4, produto.getCategoria());
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
    public boolean updateProduto(int id, Produto produto) {
        connectToDB();
        // Atualiza as informações de um produto específico
        String sql = "UPDATE Produto SET nome=?, valor=?, qtd_disponivel=?, Categoria=? where idProduto=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getValor());
            pst.setInt(3, produto.getQtd_disponivel());
            pst.setString(4, produto.getCategoria());
            pst.setInt(5, id);
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
    public boolean deleteProduto(int id) {
        connectToDB();
        // Remove um produto da tabela
        String sql = "DELETE FROM Produto where idProduto=?";
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
    public ArrayList<Produto> selectProduto() {
        ArrayList<Produto> produtos = new ArrayList<>();
        connectToDB();
        // Exibe todos os produtos cadastrados
        String sql = "SELECT * FROM Produto";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de produtos: ");
            while (rs.next()) {
                Produto produtoAux = new Produto(rs.getInt("idProduto"),rs.getString("nome"),rs.getDouble("valor"),rs.getInt("qtd_disponivel"),rs.getString("categoria"));
                System.out.println("ID = " + produtoAux.getIdProduto());
                System.out.println("Nome = " + produtoAux.getNome());
                System.out.println("Valor = R$ " + String.format("%.2f",produtoAux.getValor()));
                System.out.println("Qtd disponível = " + produtoAux.getQtd_disponivel());
                System.out.println("Categoria = " + produtoAux.getCategoria());
                System.out.println("--------------------------------");
                produtos.add(produtoAux);
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
        return produtos;
    }

    // Mostra todas as informações referentes a um único produto
    public Produto selectProdutoEspecifico(int idProduto) {
        Produto produtoAux = null;
        connectToDB();
        String sql = "SELECT * FROM Produto WHERE idProduto = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,idProduto);
            rs = pst.executeQuery();
            System.out.println("Informações do Produto " + idProduto + " :");
            if (rs.next()) {
                produtoAux = new Produto(rs.getInt("idProduto"),rs.getString("nome"),rs.getDouble("valor"),rs.getInt("qtd_disponivel"),rs.getString("categoria"));
                System.out.println("Nome = " + produtoAux.getNome());
                System.out.println("Valor = R$ " + String.format("%.2f",produtoAux.getValor()));
                System.out.println("Qtd disponível = " + produtoAux.getQtd_disponivel());
                System.out.println("Categoria = " + produtoAux.getCategoria());
                System.out.println("--------------------------------");
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return produtoAux;
    }

    // Diminui 1 unidade do estoque do produto ao realizar uma compra
    public boolean diminuirEstoque(int idProduto) {
        connectToDB();
        String sql = "UPDATE Produto SET qtd_disponivel= qtd_disponivel - 1 WHERE idProduto=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idProduto);
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
}