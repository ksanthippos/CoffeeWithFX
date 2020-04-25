package com.ksanthippos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Omistaja {

    private GridPane asettelu;
    private Button lisaaNappi;
    private Kahvila kahvila;

    public Omistaja(Kahvila kahvila) {
        this.kahvila = kahvila;
        this.asettelu = new GridPane();
        this.lisaaNappi = new Button("Lisää tuote");
    }

    public Parent nakyma(Stage stage) {

        stage.setTitle("Tervetuloa, omistaja!");

        asettelu.setPadding(new Insets(10,10,10,10));
        asettelu.setHgap(10);
        asettelu.setVgap(8);
        asettelu.setPrefSize(400, 300);
        asettelu.setAlignment(Pos.CENTER);

        paivita(kahvila, asettelu, lisaaNappi);
        asettelu.getChildren().add(lisaaNappi);

        lisaaNappi.setOnAction(e -> {
            LisaaTuote lisaaTuote = new LisaaTuote(kahvila);
            lisaaTuote.lisaa();
            paivita(kahvila, asettelu, lisaaNappi);
            asettelu.getChildren().add(lisaaNappi);
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

            Button poistaNappi = new Button("Poista");
            poistaNappi.setOnAction(ee -> {
                kahvila.poistaTuote(a);
                pane.getChildren().removeAll(nimi, poistaNappi);
            });
            GridPane.setConstraints(poistaNappi, 1, k);
            pane.getChildren().addAll(nimi, poistaNappi);

            k = k + 1;

        }

        GridPane.setConstraints(nappi, 0, k);

    }

}
