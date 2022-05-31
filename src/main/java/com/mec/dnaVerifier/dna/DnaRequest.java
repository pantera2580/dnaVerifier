package com.mec.dnaVerifier.dna;

import java.util.ArrayList;
import java.util.List;

public class DnaRequest {
    private List<String> dna = new ArrayList<>();

    public DnaRequest() {
    }

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }
}
