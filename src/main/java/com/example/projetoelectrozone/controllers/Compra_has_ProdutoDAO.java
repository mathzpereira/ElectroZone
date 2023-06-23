package com.example.projetoelectrozone.controllers;

import com.example.projetoelectrozone.models.Carrinho_has_Produto;
import com.example.projetoelectrozone.models.Compra_has_Produto;

import java.sql.SQLException;

public class Compra_has_ProdutoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCompra_has_Produto(int Compra_idCompra, int Produto_idProduto) {
        connectToDB();
        Compra_has_Produto compraHasProduto = new Compra_has_Produto(Compra_idCompra, Produto_idProduto);
        String sql = "INSERT INTO Compra_has_Produto (Compra_idCompra, Produto_idProduto) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, compraHasProduto.getCompra_idCompra());
            pst.setInt(2, compraHasProduto.getProduto_idProduto());
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
