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
        String sql = "INSERT INTO Produto (idProduto, nome, valor, qtd_disponivel, Categoria_idCategoria) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, produto.getIdProduto());
            pst.setString(2, produto.getNome());
            pst.setDouble(3, produto.getValor());
            pst.setInt(4, produto.getQtd_disponivel());
            pst.setInt(5, produto.getCategoria_idCategoria());
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
    /*public boolean updateProduto(int id, Produto produto) {
        connectToDB();
        String sql = "UPDATE user SET nome=?, cpf=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getCpf());
            pst.setInt(3,id);
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
    public boolean deleteUser(int id) {
        connectToDB();
        String sql = "DELETE FROM user where id=?";
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
    public ArrayList<User> selectUser() {
        ArrayList<User> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM user";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de users: ");
            while (rs.next()) {
                User userAux = new User(rs.getString("nome"),rs.getString("cpf"));
                System.out.println("nome = " + userAux.getNome());
                System.out.println("cpf = " + userAux.getCpf());
                System.out.println("--------------------------------");
                users.add(userAux);
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
        return users;
    }*/
}