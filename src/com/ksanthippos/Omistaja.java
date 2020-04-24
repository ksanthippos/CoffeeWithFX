package com.ksanthippos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Omistaja {

    private GridPane asettelu;
    private Button lisaaNappi;

    public Omistaja() {
        this.asettelu = new GridPane();
        this.lisaaNappi = new Button("Lisää tuote");
    }

    public Parent nakyma() {




        asettelu.setPadding(new Insets(10,10,10,10));
        asettelu.setHgap(10);
        asettelu.setVgap(8);
        asettelu.setPrefSize(400, 300);

        asettelu.getChildren().add(lisaaNappi);
        asettelu.setAlignment(Pos.CENTER);



        return asettelu;

    }

}
