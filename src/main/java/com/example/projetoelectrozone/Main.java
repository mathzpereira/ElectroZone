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
import java.util.Scanner;

public class Main{// extends Application {
    public static void main(String[] args) {

        //declaracao das variaveis
        boolean flag=true;
        boolean sucesso=false;
        int opcao;

        ProdutoDAO pd = new ProdutoDAO();
        CategoriaDAO ctd = new CategoriaDAO();
        CompraDAO cpd = new CompraDAO();
        EnderecoDAO ed = new EnderecoDAO();
        UsuarioDAO ud = new UsuarioDAO();
        CarrinhoDAO crd = new CarrinhoDAO();
        ImagemDAO id = new ImagemDAO();
        Carrinho_has_ProdutoDAO chpd = new Carrinho_has_ProdutoDAO();


        Categoria c = new Categoria("Limpeza");
        Produto p = new Produto("Shampoo",49.99,10,1);
        Usuario u1 = new Usuario("12345678910","Givanildo Vieira", "hulk@gmail.com","123");
        Endereco e1 = new Endereco("Rua 1", "Centro", 7,"37540000",1);
        Compra c1 =  new Compra(200.00,"2023-06-07",1);
        Carrinho cr = new Carrinho(1);
        Carrinho_has_Produto chp = new Carrinho_has_Produto(1,1);

        ctd.insertCategoria(c);
        pd.insertProduto(p);
        ud.insertUsuario(u1);
        ed.insertEndereco(e1);
        cpd.insertCompra(c1);
        crd.insertCarrinho(cr);
        chpd.insertCarrinho_has_Produto(chp);


        //entrada de dados
        Scanner in = new Scanner(System.in);


        while(flag){

            System.out.println("Bem-vindo à Electrozone");
            System.out.print("Digite seu e-mail: ");
            String email = in.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = in.nextLine();
            try{
                ud.selectUsuario();
                if(senha.equals("2"))
                    throw new LoginFailedException();
            }catch (LoginFailedException e){
                break;
            }

            if(sucesso){
                System.out.println("Menu ElectroZone");
                System.out.println("1 - Cadastrar usuario");
                System.out.println("2 - Listar Produtos");
                System.out.println("3 - Comprar Produto");
                System.out.println("4 - Ver carrinho");
                System.out.println("5 - Adicionar novo produto");
                System.out.println("6 - Remover produto carrinho");
                System.out.println("7 - Atualizar produto");
                System.out.println("8 - ");
                opcao = in.nextInt();
                switch (opcao){
                    case 1:
                        pd.selectProduto();
                    case 2:
                        System.out.print("Informe o id do Produto: ");
                        int idproduto = in.nextInt();
                        chpd.insertCarrinho_has_Produto(chp);
                }
            }




        }

    }
