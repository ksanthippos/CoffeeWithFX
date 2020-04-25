package com.ksanthippos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Asiakas {

    private BorderPane nakyma;
    private GridPane asettelu;
    private Button ostaNappi;
    private Kahvila kahvila;
    private Label saldoLabel;
    private Label nimiLabel;
    private int saldo;


    public Asiakas(Kahvila kahvila) {
        this.nakyma = new BorderPane();
        this.asettelu = new GridPane();
        this.kahvila = kahvila;
        this.saldo = 10;
        this.saldoLabel = new Label();
        this.ostaNappi = new Button("Osta");
        saldoLabel.setText("Saldo: 10 €");
    }

    public Parent nakyma(Stage stage) {

        stage.setTitle("Tervetuloa, asiakas!");

        asettelu.setPadding(new Insets(10,10,10,10));
        asettelu.setHgap(10);
        asettelu.setVgap(8);
        asettelu.setPrefSize(500, 300);
        asettelu.setAlignment(Pos.CENTER);

        nakyma.setPadding(new Insets(20, 0, 0, 20));
        nakyma.setCenter(asettelu);
        nakyma.setTop(saldoLabel);

        paivita(kahvila, asettelu, ostaNappi);

        ostaNappi.setOnAction(e -> {
            paivita(kahvila, asettelu, ostaNappi);
        });

        return nakyma;

    }

    public void paivita(Kahvila kahvila, GridPane asettelu, Button nappi) {

        int k = 0;
        asettelu.getChildren().clear();

        for (Tuote a : kahvila.getTuote()) {

            nimiLabel = new Label();
            nimiLabel.setText(a.getNimi() + ", " + a.getHinta() + "€");
            GridPane.setConstraints(nimiLabel, 0, k);

            Button ostaNappi = new Button("Osta");
            ostaNappi.setOnAction(e -> {

                if (a.getHinta() > saldo) {
                    Alert info = new Alert(Alert.AlertType.WARNING);
                    info.setHeaderText("Saldosi ei riitä");
                    info.setContentText("Sinulla on " + saldo + " euroa, " +
                                            "mutta tuote maksaa " + a.getHinta() + " euroa.");
                    info.showAndWait();
                }
                else {
                    saldo = saldo - a.getHinta();
                    saldoLabel.setText("Saldo : " + saldo + " €");
                }
            });

            GridPane.setConstraints(ostaNappi, 1, k);
            asettelu.getChildren().addAll(nimiLabel, ostaNappi);

            k++;
        }

        GridPane.setConstraints(nappi, 0, k);

    }
}
