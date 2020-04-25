package com.ksanthippos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Asiakas {

    private GridPane asettelu;
    private Button ostaNappi;

    public Asiakas() {
        this.asettelu = new GridPane();
        this.ostaNappi = new Button("Osta");
    }

    public Parent nakyma(Stage stage) {

        stage.setTitle("Tervetuloa, asiakas!");

        asettelu.setPadding(new Insets(10,10,10,10));
        asettelu.setHgap(10);
        asettelu.setVgap(8);
        asettelu.setPrefSize(400, 300);

        asettelu.getChildren().add(ostaNappi);
        asettelu.setAlignment(Pos.CENTER);



        return asettelu;

    }
}
