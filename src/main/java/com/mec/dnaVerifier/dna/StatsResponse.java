package com.mec.dnaVerifier.dna;

public class StatsResponse {
    private long count_correct_dna;
    private long count_defect_dna;
    private double ratio;

    public StatsResponse() {
    }

    public long getCount_correct_dna() {
        return count_correct_dna;
    }

    public void setCount_correct_dna(long count_correct_dna) {
        this.count_correct_dna = count_correct_dna;
    }

    public long getCount_defect_dna() {
        return count_defect_dna;
    }

    public void setCount_defect_dna(long count_defect_dna) {
        this.count_defect_dna = count_defect_dna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
