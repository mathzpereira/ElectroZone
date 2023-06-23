package com.example.projetoelectrozone;

import com.example.projetoelectrozone.controllers.*;
import com.example.projetoelectrozone.menu.MenuHelper;
import com.example.projetoelectrozone.menu.MenuLogin;
import com.example.projetoelectrozone.menu.MenuLoja;
import com.example.projetoelectrozone.models.*;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main implements MenuLogin, MenuLoja { // Implementação de 2 Interfaces

    public static void main(String[] args) {

        // Variáveis auxiliares
        boolean flag = true;
        boolean sucesso = false;
        String email = null;
        String senha = null;
        Usuario aux = null;

        // Classe que conecta com BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Scanner in = new Scanner(System.in);
        while (flag) { // Loop para fazer login

            System.out.println("------------------------------------------------");
            System.out.println("ElectroZone - O melhor lugar para comprar seus eletrônicos");
            System.out.println("Digite 1 - Para fazer login");
            System.out.println("Digite 2 - Para se cadastrar");
            System.out.println("Digite 3 - Para encerrar");
            System.out.println("------------------------------------------------");

            int opLogin = in.nextInt();
            while (opLogin != 1 && opLogin != 2 && opLogin != 3) { // Crítica de dados
                System.out.println("Opção Inválida. Digite 1 para fazer login ou 2 para se cadastrar ou 3 para encerrar: ");
                opLogin = in.nextInt();
            }
            if (opLogin == 1) { // Login
                try {
                    aux = MenuLogin.loginUsuario(); // Autenticação do usuário
                    sucesso = aux.sucesso;
                    System.out.println("Login realizado com sucesso!");
                    System.out.println("------------------------------------------------");
                    System.out.println("Seja bem-vindo, "+aux.getNome()+"!");
                }catch (NullPointerException e){
                }

            } else if (opLogin == 2) // Registro
                MenuLogin.registrarUsuario();
            else if (opLogin == 3) // Encerrar
                flag = false;

            while (sucesso) { // Loop do menu da loja (após login)
                email = aux.getEmail();
                senha = aux.getSenha();
                MenuHelper mh = null;
                Usuario u = usuarioDAO.selectUsuarioLogin(email, senha); // Retorna o usuário após logar
                if (u.getCargo().equals("Cliente")) { // Menu do Cliente
                    mh = MenuLoja.menuCliente(u);
                    flag = mh.isFlag();
                    sucesso = mh.isSucesso();
                }
                else if (u.getCargo().equals("Administrador")){ // Menu do ADM
                    mh = MenuLoja.menuADM();
                    flag = mh.isFlag();
                    sucesso = mh.isSucesso();
                }
            }

        }

    }
}
