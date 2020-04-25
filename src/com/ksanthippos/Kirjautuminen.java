package com.ksanthippos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Kirjautuminen {

    private BorderPane paaNakyma;
    private GridPane asettelu;
    private Omistaja omistaja;
    private Asiakas asiakas;

    public Kirjautuminen(Kahvila kahvila) {

        this.paaNakyma = new BorderPane();
        this.asettelu = new GridPane();
        this.omistaja = new Omistaja(kahvila);
        this.asiakas = new Asiakas(kahvila);

    }

    public Parent kirjautumisNakyma(Stage stage) {

        stage.setTitle("Kirjaudu sisään");
        asettelu.setHgap(8);
        asettelu.setVgap(10);
        asettelu.setPadding(new Insets(10,10,10,10));
        asettelu.setPrefSize(400, 300);

        Label nimiLabel = new Label("Käyttäjänimi:");
        GridPane.setConstraints(nimiLabel, 1,1);

        TextField nimiInput = new TextField();
        nimiInput.setPromptText("käyttäjätunnus");
        GridPane.setConstraints(nimiInput, 2,1);

        Label salaLabel = new Label("Salasana:");
        GridPane.setConstraints(salaLabel, 1,2);

        PasswordField salaInput = new PasswordField();
        salaInput.setPromptText("salasana");
        GridPane.setConstraints(salaInput, 2,2);
        Button kirjauduNappi = new Button("Kirjaudu");
        Label virheLabel = new Label("");
        virheLabel.setFont(Font.font(14));
        virheLabel.setTextFill(Color.RED);
        GridPane.setConstraints(virheLabel, 2,0);
        GridPane.setConstraints(kirjauduNappi, 4,1);


        kirjauduNappi.setOnAction(e -> {
            if (nimiInput.getText().equals("o") && salaInput.getText().equals("")){
                Scene omistajaNakyma = new Scene(omistaja.nakyma(stage));
                paaNakyma.setCenter(omistajaNakyma.getRoot());
            }
            else if (nimiInput.getText().equals("") && salaInput.getText().equals("")) {
                Scene asiakasNakyma = new Scene(asiakas.nakyma(stage));
                paaNakyma.setCenter(asiakasNakyma.getRoot());
            }
            else {
                virheLabel.setText("Väärä tunnus tai salasana");
            }
        });

        asettelu.setAlignment(Pos.CENTER);
        asettelu.getChildren().addAll(nimiLabel, nimiInput, salaLabel, salaInput, kirjauduNappi, virheLabel);
        paaNakyma.setCenter(asettelu);

        return paaNakyma;

    }



}
