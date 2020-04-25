package com.ksanthippos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        MenuBar menuBar = new MenuBar();
        Menu menu= new Menu("Asetukset");
        MenuItem kirjaudu = new MenuItem("Kirjaudu sisään");
        MenuItem lopeta = new MenuItem("Lopeta");
        menu.getItems().addAll(kirjaudu, lopeta);
        menuBar.getMenus().addAll(menu);

        kirjaudu.setOnAction(e -> {

            BorderPane paaNakyma = new BorderPane();
            Kirjautuminen kirjautuminen = new Kirjautuminen();
            paaNakyma.setTop(menuBar);
            paaNakyma.setCenter(kirjautuminen.kirjautumisNakyma(stage));
            Scene scene = new Scene(paaNakyma);
            stage.setScene(scene);
            stage.show();

        });

        lopeta.setOnAction(e -> {
            System.exit(0);
        });

        // tämä luodaan, kun ohjelma käynnistyy --> siksi tuplana kirjadu - actionissa
        BorderPane paaNakyma = new BorderPane();
        paaNakyma.setPrefSize(400, 300);
        Kirjautuminen kirjautuminen = new Kirjautuminen();
        paaNakyma.setTop(menuBar);
        paaNakyma.setCenter(kirjautuminen.kirjautumisNakyma(stage));
        Scene scene = new Scene(paaNakyma);
        stage.setScene(scene);
        stage.show();


    }

}
