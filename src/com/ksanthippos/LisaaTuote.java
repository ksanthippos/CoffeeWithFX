package com.ksanthippos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LisaaTuote {

    private Kahvila kahvila;

    public LisaaTuote(Kahvila kahvila){
        this.kahvila = kahvila;
    }

    public void lisaa() {

        Stage stage = new Stage();
        stage.setTitle("Lisää tuote");
        GridPane asettelu = new GridPane();
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        asettelu.setVgap(8);
        asettelu.setHgap(10);

        Label nimiLabel = new Label("Anna tuotteen nimi: ");
        GridPane.setConstraints(nimiLabel, 0, 0);
        TextField nimiInput = new TextField();
        GridPane.setConstraints(nimiInput, 1, 0);
        Label hintaLabel = new Label("Anna hinta: ");
        GridPane.setConstraints(hintaLabel, 0, 1);
        TextField hintaInput = new TextField();
        GridPane.setConstraints(hintaInput, 1, 1);
        Button lisaaNappi = new Button("Lisää");

        lisaaNappi.setOnAction(e -> {

            int hinta = Integer.parseInt(hintaInput.getText());
            String nimi = nimiInput.getText();
            Tuote a = new Tuote(nimi, hinta);
            kahvila.lisaaTuote(a);
            stage.close();

        });

        GridPane.setConstraints(lisaaNappi, 0, 2);
        Button suljeNappi = new Button("Sulje");
        GridPane.setConstraints(suljeNappi, 1, 2);
        suljeNappi.setOnAction(e -> stage.close());
        asettelu.getChildren().addAll(nimiLabel, nimiInput, hintaLabel, hintaInput, lisaaNappi, suljeNappi);

        asettelu.setAlignment(Pos.CENTER);
        Scene scene = new Scene(asettelu);
        stage.setScene(scene);
        stage.showAndWait();

    }

}
