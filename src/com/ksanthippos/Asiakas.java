package com.ksanthippos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Asiakas {

    private GridPane asettelu;
    private Button ostaNappi;
    private Kahvila kahvila;

    public Asiakas(Kahvila kahvila) {
        this.asettelu = new GridPane();
        this.ostaNappi = new Button("Osta");
        this.kahvila = kahvila;
    }

    public Parent nakyma(Stage stage) {

        stage.setTitle("Tervetuloa, asiakas!");

        asettelu.setPadding(new Insets(10,10,10,10));
        asettelu.setHgap(10);
        asettelu.setVgap(8);
        asettelu.setPrefSize(400, 300);

        asettelu.getChildren().add(ostaNappi);
        asettelu.setAlignment(Pos.CENTER);

        paivita(kahvila, asettelu, ostaNappi);

        ostaNappi.setOnAction(e -> {
            paivita(kahvila, asettelu, ostaNappi);
            asettelu.getChildren().add(ostaNappi);
        });
        return asettelu;

    }

    public static void paivita(Kahvila kahvila, GridPane pane, Button nappi) {

        int k = 0;
        pane.getChildren().clear();

        for (Tuote a : kahvila.getTuote()) {

            Label nimi = new Label();
            nimi.setText(a.getNimi() + ", " + a.getHinta() + "€");
            GridPane.setConstraints(nimi, 0,k);

            Button ostaNappi = new Button("Osta");
            ostaNappi.setOnAction(ee -> {
                System.out.println("Ostit tuotteen!");
                System.out.println("Tuotteen nimi: " + a.getNimi());
            });
            GridPane.setConstraints(ostaNappi, 1, k);
            pane.getChildren().addAll(nimi, ostaNappi);

            k = k + 1;

        }

        GridPane.setConstraints(nappi, 0, k);

    }
}
