package com.example.projetoelectrozone;

import com.example.projetoelectrozone.controllers.*;
import com.example.projetoelectrozone.models.Carrinho;
import com.example.projetoelectrozone.models.Endereco;
import com.example.projetoelectrozone.models.Usuario;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public interface MenuLogin {

    public static void registrarUsuario(){
        Scanner in = new Scanner(System.in);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

        System.out.println("Cadastro de Usuário: ");
        System.out.print("E-mail: ");
        String email = in.nextLine();
        System.out.print("Senha: ");
        String senha = in.nextLine();
        System.out.println("Digite suas informações: ");
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("CPF: ");
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

    public static Usuario loginUsuario() {
        Scanner in = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = null;

        System.out.print("Digite seu e-mail: ");
        String email = in.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = in.nextLine();
        try {
            u = usuarioDAO.selectUsuarioLogin(email, senha);
            if (u == null)
                throw new LoginFailedException();
            else
                u.sucesso = true;
        } catch (LoginFailedException e) {
        }
        return u;
    }

}
