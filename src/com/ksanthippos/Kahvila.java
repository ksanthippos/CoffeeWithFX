package com.ksanthippos;

import java.util.ArrayList;
import java.util.List;

public class Kahvila {

    private List<Tuote> tuotteet;

    public Kahvila() {
        this.tuotteet = new ArrayList<>();

        // valmiit tuotteet
        tuotteet.add(new Tuote("omppu", 1));
        tuotteet.add(new Tuote("piirakka", 5));
        tuotteet.add(new Tuote("mustikkapiirakka", 5));
    }

    public List<Tuote> getTuote() {
        return tuotteet;
    }

    public int getKoko() { return tuotteet.size(); }

    public void lisaaTuote(Tuote tuote) {
        tuotteet.add(tuote);
    }

    public void poistaTuote(Tuote tuote) {
        if (tuotteet.contains(tuote)) {
            tuotteet.remove(tuote);
        }
    }


    // tuotteen poistaminen Stringillä
/*    public void poistaTuote(String poistettava) {

        int indeksi = -1;
        for (Tuote tuote: tuotteet) {
            if (tuote.getNimi().equals(poistettava)) {
                indeksi = tuotteet.indexOf(tuote);
            }
        }

        if (indeksi == -1) {
            System.out.println("Tuotetta ei ole");
        } else {
            System.out.println("Tuote poistettiin!");
            tuotteet.remove(indeksi);
        }

    }*/




}


