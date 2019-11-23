package com.example.myapplication.Model;

import java.util.List;

public class CelularContainer {

    private List <Celular> results;

    public CelularContainer(List<Celular> results) {
        this.results = results;
    }

    public CelularContainer() {
    }

    public List<Celular> getResults() {
        return results;
    }

    public void setResults(List<Celular> results) {
        this.results = results;
    }
}
