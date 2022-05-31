package com.mec.dnaVerifier.dna;

import java.util.Date;

public class DnaResponse {
    private boolean isMalformed;
    private String structureToString;
    private int dimension;
    private Date createdAt;

    public DnaResponse() {
    }
    public boolean isMalformed() {
        return isMalformed;
    }

    public void setMalformed(boolean malformed) {
        isMalformed = malformed;
    }

    public String getStructureToString() {
        return structureToString;
    }

    public void setStructureToString(String structureToString) {
        this.structureToString = structureToString;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
