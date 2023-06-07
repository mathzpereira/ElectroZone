package com.example.projetoelectrozone;

import com.example.projetoelectrozone.controllers.CategoriaDAO;
import com.example.projetoelectrozone.controllers.ProdutoDAO;
import com.example.projetoelectrozone.models.Categoria;
import com.example.projetoelectrozone.models.Produto;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main{// extends Application {
    public static void main(String[] args) {

        ProdutoDAO pd = new ProdutoDAO();
        CategoriaDAO cd = new CategoriaDAO();
        Categoria c = new Categoria("Limpeza");
        Produto p = new Produto("Sabonete",100,5,1);
        cd.insertCategoria(c);
        pd.insertProduto(p);
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
