package com.example.projetoelectrozone.controllers;
import com.example.projetoelectrozone.models.Compra;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public int selectUltimaCompraID(int idUsuario) {
        connectToDB();
        String sql = "SELECT idCompra FROM compra c, usuario u WHERE u.idUsuario = c.usuario_idusuario AND c.usuario_idusuario=? ORDER BY idCompra DESC LIMIT 1";
        int id = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt("idCompra");
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

    public void verCompras(int idUsuario) {
        connectToDB();
        String sql = "SELECT c.idCompra, c.data, c.valor as valorCompra, p.nome, p.valor FROM compra c, usuario u, produto p, compra_has_produto chp WHERE u.idUsuario = c.usuario_idusuario AND chp.Compra_idCompra = c.idCompra AND chp.Produto_idProduto = p.idProduto AND u.idUsuario = ? ORDER BY c.idCompra";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();
            System.out.println("Lista de Compras: ");
            int idCompraAnterior = -1; // Variável para acompanhar o ID da compra anterior
            while (rs.next()) {
                int idCompra = rs.getInt("idCompra");
                if (idCompra != idCompraAnterior) {
                    Compra compraAux = new Compra(idCompra, rs.getDouble("valorCompra"), rs.getString("data"));
                    System.out.println("--------------------------------");
                    System.out.println("ID = " + compraAux.getIdCompra());
                    System.out.println("Data = " + compraAux.getData());
                    System.out.println("Valor Total = R$ " + String.format("%.2f",compraAux.getValor()));
                    System.out.println("Produtos: ");
                    idCompraAnterior = idCompra; // Atualiza o ID da compra anterior
                }
                String nomeProduto = rs.getString("nome");
                Double valorProduto = rs.getDouble("valor");
                System.out.println("Nome: " + nomeProduto);
                System.out.println("Valor: R$ " + String.format("%.2f",valorProduto));
            }
            System.out.println("--------------------------------");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    /*public void verCompras(int idUsuario) {
        connectToDB();
        String sql = "SELECT c.idCompra, c.data, c.valor, p.nome, p.valor FROM compra c, usuario u, produto p, compra_has_produto chp WHERE u.idUsuario = c.usuario_idusuario AND chp.Compra_idCompra = c.idCompra AND chp.Produto_idProduto = p.idProduto";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();
            System.out.println("Lista de Compras: ");
            while (rs.next()){
                Compra compraAux = new Compra(rs.getInt("idCompra"),rs.getDouble("valor"),rs.getString("data"),rs.getInt("Usuario_idUsuario"));
                System.out.println("ID = " + compraAux.getIdCompra());
                System.out.println("Data = " + compraAux.getData());
                System.out.println("Valor = " + compraAux.getValor());
                System.out.println("Produtos: ");
                System.out.println("--------------------------------");
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
    }*/
}