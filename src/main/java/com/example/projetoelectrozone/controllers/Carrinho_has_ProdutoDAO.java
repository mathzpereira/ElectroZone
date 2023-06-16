package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Carrinho_has_Produto;
import com.example.projetoelectrozone.models.Endereco;

import java.sql.SQLException;
import java.util.ArrayList;

public class Carrinho_has_ProdutoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCarrinho_has_Produto(Carrinho_has_Produto carrinhoHasProduto) {
        connectToDB();
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
}
