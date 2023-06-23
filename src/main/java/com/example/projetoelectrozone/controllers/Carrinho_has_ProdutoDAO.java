package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Carrinho_has_Produto;
import com.example.projetoelectrozone.models.Endereco;
import com.example.projetoelectrozone.models.Produto;

import java.sql.SQLException;
import java.util.ArrayList;

public class Carrinho_has_ProdutoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCarrinho_has_Produto(int carrinho_idCarrinho, int produto_idProduto) {
        connectToDB();
        Carrinho_has_Produto carrinhoHasProduto = new Carrinho_has_Produto(carrinho_idCarrinho, produto_idProduto);
        String sql = "INSERT INTO Carrinho_has_Produto (Carrinho_idCarrinho, Produto_idProduto) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, carrinhoHasProduto.getCarrinho_idCarrinho());
            pst.setInt(2, carrinhoHasProduto.getProduto_idProduto());
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

    public boolean deleteCarrinho_Has_Produto(int idCarrinho, int idProduto) {
        connectToDB();
        String sql = "DELETE FROM carrinho_has_produto where Carrinho_idCarrinho=? AND Produto_idProduto=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCarrinho);
            pst.setInt(2, idProduto);
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

    public double exibirProdutosCarrinho(int idUsuario) {
        connectToDB();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        int idCarrinho = carrinhoDAO.selectCarrinhoID(idUsuario);
        double valorPedido = 0;
        String sql = "SELECT p.idProduto, p.nome, p.valor FROM produto as p, carrinho_has_produto as chp, carrinho as c WHERE p.idProduto = chp.produto_idProduto AND chp.carrinho_idCarrinho = c.idCarrinho AND chp.carrinho_idCarrinho =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,idCarrinho);
            rs = pst.executeQuery();
            System.out.println("--------------------------------");
            System.out.println("Carrinho: ");
            while (rs.next()) {
                Produto produtoAux = new Produto(rs.getInt("idProduto"),rs.getString("nome"),rs.getDouble("valor"));
                System.out.println("ID = " + produtoAux.getIdProduto());
                System.out.println("Nome = " + produtoAux.getNome());
                System.out.println("Valor = R$ " + String.format("%.2f",produtoAux.getValor()));
                System.out.println("--------------------------------");
                valorPedido += produtoAux.getValor();
            }
            System.out.println("Valor da Compra no Carrinho: R$ " + String.format("%.2f",valorPedido));
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
        return valorPedido;
    }

    public ArrayList<Integer> selectProdutosCarrinho(int idCarrinho){
        connectToDB();
        ArrayList<Integer> produtos = new ArrayList<>();
        String sql = "SELECT p.idProduto FROM produto as p, carrinho_has_produto as chp, carrinho as c WHERE p.idProduto = chp.produto_idProduto AND chp.carrinho_idCarrinho = c.idCarrinho AND chp.carrinho_idCarrinho =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,idCarrinho);
            rs = pst.executeQuery();
            while (rs.next()) {
                produtos.add(rs.getInt("idProduto"));
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
        return produtos;
    }

    public boolean removerItensCarrinho(int idCarrinho) {
        connectToDB();
        String sql = "DELETE FROM carrinho_has_produto where Carrinho_idCarrinho=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCarrinho);
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
