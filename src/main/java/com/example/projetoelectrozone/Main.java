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

public class Main{// extends Application {
    public static void main(String[] args) {

        ProdutoDAO pd = new ProdutoDAO();
        CategoriaDAO ctd = new CategoriaDAO();
        CompraDAO cpd = new CompraDAO();
        EnderecoDAO ed = new EnderecoDAO();
        UsuarioDAO ud = new UsuarioDAO();
        CarrinhoDAO crd = new CarrinhoDAO();
        ImagemDAO id = new ImagemDAO();
        Carrinho_has_ProdutoDAO chpd = new Carrinho_has_ProdutoDAO();

        /*try {
            FileInputStream im = new FileInputStream("/src/main/java/com/example/projetoelectrozone/images/electrozonemodel.png");
            Imagem img = new Imagem("nome1",im,1);
            id.insertImagem(img);
        } catch (IOException io1){
            System.out.println("Erro ao abrir o arquivo: " + io1);
        }*/
        Categoria c = new Categoria("Limpeza");
        Produto p = new Produto("Shampoo",49.99,10,1);
        Usuario u1 = new Usuario("12345678910","Givanildo Vieira", "hulk@gmail.com","123");
        Endereco e1 = new Endereco("Rua 1", "Centro", 7,"37540000",1);
        Compra c1 =  new Compra(200.00,"2023-06-07",1);
        Carrinho cr = new Carrinho(1);
        Carrinho_has_Produto chp = new Carrinho_has_Produto(1,1);
        /*ctd.insertCategoria(c);
        pd.insertProduto(p);
        ud.insertUsuario(u1);
        ed.insertEndereco(e1);
        cpd.insertCompra(c1);
        crd.insertCarrinho(cr);
        chpd.insertCarrinho_has_Produto(chp);*/
        //launch();
    }

    /*@Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    //}
}
