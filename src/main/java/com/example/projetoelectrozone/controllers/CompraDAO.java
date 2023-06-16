package com.example.projetoelectrozone.controllers;
import com.example.projetoelectrozone.models.Compra;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompraDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCompra(Compra compra) {
        connectToDB();
        String sql = "INSERT INTO Compra (valor, data, Usuario_idUsuario) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, compra.getValor());
            pst.setString(2, compra.getData());
            pst.setInt(3, compra.getUsuario_idUsuario());
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
    public boolean updateCompra(int id, Compra compra) {
        connectToDB();
        String sql = "UPDATE Compra SET valor=?, data=?, Usuario_idUsuario=? where idCompra=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, compra.getValor());
            pst.setString(2,compra.getData());
            pst.setInt(3, compra.getUsuario_idUsuario());
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
    public boolean deleteCompra(int id) {
        connectToDB();
        String sql = "DELETE FROM Compra where idCompra=?";
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
    public ArrayList<Compra> selectCompra() {
        ArrayList<Compra> Compras = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Compra";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Compras: ");
            while (rs.next()) {
                Compra compraAux = new Compra(rs.getInt("idCompra"),rs.getDouble("valor"),rs.getString("data"),rs.getInt("Usuario_idUsuario"));
                System.out.println("ID = " + compraAux.getIdCompra());
                System.out.println("Valor = " + compraAux.getValor());
                System.out.println("Data = " + compraAux.getData());
                System.out.println("Usuário = " + compraAux.getUsuario_idUsuario());
                System.out.println("--------------------------------");
                Compras.add(compraAux);
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
        return Compras;
    }
}