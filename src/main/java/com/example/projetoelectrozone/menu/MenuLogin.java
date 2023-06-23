package com.example.projetoelectrozone.menu;

import com.example.projetoelectrozone.controllers.*;
import com.example.projetoelectrozone.exceptions.LoginFailedException;
import com.example.projetoelectrozone.exceptions.RegisterFailedException;
import com.example.projetoelectrozone.models.Carrinho;
import com.example.projetoelectrozone.models.Endereco;
import com.example.projetoelectrozone.models.Usuario;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public interface MenuLogin { // Interface com todos os métodos de autenticação

    static void registrarUsuario(){
        // Instanciando as classes
        Scanner in = new Scanner(System.in);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

        // Entrada de dados
        System.out.println("Cadastro de Usuário: ");
        System.out.print("E-mail: ");
        String email = in.nextLine();
        System.out.print("Senha: ");
        String senha = in.nextLine();
        System.out.println("Digite suas informações: ");
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("CPF (somente números): ");
        String cpf = in.nextLine();
        System.out.println("Endereço: ");
        System.out.print("Rua: ");
        String rua = in.nextLine();
        System.out.print("Número: ");
        int numero = parseInt(in.nextLine());
        System.out.print("Bairro: ");
        String bairro = in.nextLine();
        System.out.print("CEP (somente números): ");
        String cep = in.nextLine();

        try {
            // Cria um novo usuário, endereço e carrinho e manda para o banco de dados
            Usuario usuario = new Usuario(cpf, nome, email, senha, "Cliente", 0);
            usuarioDAO.insertUsuario(usuario);
            int id = usuarioDAO.selectUsuarioID(email, senha);
            Endereco endereco = new Endereco(rua, bairro, numero, cep, id);
            usuario.setEndereco(endereco);
            enderecoDAO.insertEndereco(endereco);
            Carrinho carrinho = new Carrinho(id);
            usuario.setCarrinho(carrinho);
            carrinhoDAO.insertCarrinho(carrinho);
            System.out.println("Usuário criado com sucesso\n");
        } catch (Exception e){
                new RegisterFailedException();
        }
    }

    static void registrarADM(){
        // Instanciando as classes
        Scanner in = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Entrada de dados
        System.out.println("Cadastro de Administrador: ");
        System.out.print("E-mail: ");
        String email = in.nextLine();
        System.out.print("Senha: ");
        String senha = in.nextLine();
        try {
            // Cria um novo usuário administrador e manda para o banco de dados
            Usuario usuario = new Usuario(email, senha, "Administrador");
            usuarioDAO.insertUsuario(usuario);
            System.out.println("Usuário criado com sucesso\n");
        } catch (Exception e){
            new RegisterFailedException();
        }
    }

    static Usuario loginUsuario() {
        // Instanciando as classes
        Scanner in = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario u = null;

        System.out.print("Digite seu e-mail: ");
        String email = in.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = in.nextLine();
        try {
            u = usuarioDAO.selectUsuarioLogin(email, senha); // Autenticação
            if (u == null) // Usuário não está no banco de dados
                throw new LoginFailedException();
            else
                u.sucesso = true;
        } catch (LoginFailedException e) {
        }
        return u;
    }

}
