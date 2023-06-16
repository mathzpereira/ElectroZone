package com.example.projetoelectrozone;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.layout.VBox;

import java.io.File;

public class ImageChooserExample extends Application {

    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        Button btnChooseImage = new Button("Escolher Imagem");
        imageView = new ImageView();

        // Configurando o evento de clique do botão
        btnChooseImage.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Escolher Imagem");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Arquivos de Imagem", "*.png", "*.jpg", "*.jpeg")
            );
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                // Criando uma imagem com o arquivo selecionado
                Image image = new Image(selectedFile.toURI().toString());
                // Definindo a imagem no ImageView
                imageView.setImage(image);
            }
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(btnChooseImage, imageView);

        // Configurando a cena e mostrando a janela
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exemplo de Escolha de Imagem");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
