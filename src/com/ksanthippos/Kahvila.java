package com.ksanthippos;

import java.util.ArrayList;
import java.util.List;

public class Kahvila {

    private List<Tuote> tuotteet;

    public Kahvila() {
        this.tuotteet = new ArrayList<>();
        tuotteet.add(new Tuote("sacherkakku", 3));
        tuotteet.add(new Tuote("kahvi", 2));
        tuotteet.add(new Tuote("pizzapala", 4));
    }

    public List<Tuote> getTuote() {
        return tuotteet;
    }

    public void lisaaTuote(Tuote tuote) {
        tuotteet.add(tuote);
    }

    public void poistaTuote(Tuote tuote) {
        if (tuotteet.contains(tuote)) {
            tuotteet.remove(tuote);
        }
    }

}


