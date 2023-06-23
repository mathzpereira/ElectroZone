package com.example.projetoelectrozone;

import com.example.projetoelectrozone.controllers.*;
import com.example.projetoelectrozone.models.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main implements MenuLogin{

    public static void main(String[] args) {

        //declaracao das variaveis
        boolean flag = true;
        boolean sucesso = false;
        String email = null;
        String senha = null;
        Usuario aux = null;

        ProdutoDAO produtoDAO = new ProdutoDAO();
        CompraDAO compraDAO = new CompraDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        Carrinho_has_ProdutoDAO carrinhoHasProdutoDAO = new Carrinho_has_ProdutoDAO();
        Compra_has_ProdutoDAO compraHasProdutoDAO = new Compra_has_ProdutoDAO();

        //entrada de dados
        Scanner in = new Scanner(System.in);
        while (flag) {

            System.out.println("------------------------------------------------");
            System.out.println("ElectroZone - O melhor lugar para comprar seus eletrônicos");
            System.out.println("Digite 1 - Para fazer login");
            System.out.println("Digite 2 - Para se cadastrar");
            System.out.println("Digite 3 - Para encerrar");
            System.out.println("------------------------------------------------");

            int opLogin = in.nextInt();
            while (opLogin != 1 && opLogin != 2 && opLogin != 3) {
                System.out.println("Opção Inválida. Digite 1 para fazer login ou 2 para se cadastrar ou 3 para encerrar: ");
                opLogin = in.nextInt();
            }
            if (opLogin == 1) {
                try {
                    aux = MenuLogin.loginUsuario();
                    sucesso = aux.sucesso;
                    System.out.println("Login realizado com sucesso!");
                    System.out.println("------------------------------------------------");
                    System.out.println("Seja bem-vindo, "+aux.getNome()+"!");
                }catch (NullPointerException e){
                }

            } else if (opLogin == 2)
                MenuLogin.registrarUsuario();
            else if (opLogin == 3)
                flag = false;

            while (sucesso) {
                email = aux.getEmail();
                senha = aux.getSenha();
                MenuHelper mh = null;
                Usuario u = usuarioDAO.selectUsuarioLogin(email, senha);
                if (u.getCargo().equals("Cliente")) {
                    mh = MenuLoja.menuCliente(u);
                    flag = mh.isFlag();
                    sucesso = mh.isSucesso();
                }
                else if (u.getCargo().equals("Administrador")){
                    mh = MenuLoja.menuADM(u);
                    flag = mh.isFlag();
                    sucesso = mh.isSucesso();
                }
            }


        }

    }
}
