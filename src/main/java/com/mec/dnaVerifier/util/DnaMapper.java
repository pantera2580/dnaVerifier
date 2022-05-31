package com.mec.dnaVerifier.util;

import com.mec.dnaVerifier.dna.Dna;
import com.mec.dnaVerifier.dna.DnaRequest;
import com.mec.dnaVerifier.dna.DnaResponse;

import java.util.Date;

public class DnaMapper {
    public static DnaResponse entityToResponse(Dna dna){
        DnaResponse dnaResponse = new DnaResponse();
        dnaResponse.setStructureToString(dna.getSequence());
        dnaResponse.setMalformed(dna.isMalformed());
        dnaResponse.setDimension(dna.getDimension());
        dnaResponse.setCreatedAt(dna.getCreateAt());
        return dnaResponse;
    }
    public static Dna responseToEntity(DnaResponse dnaResponse){
        Dna dna = new Dna();
        dna.setSequence(dnaResponse.getStructureToString());
        dna.setMalformed(dnaResponse.isMalformed());
        dna.setCreateAt(dnaResponse.getCreatedAt());
        dna.setDimension(dnaResponse.getDimension());
        return dna;
    }

    public static String dnaStructureToString(DnaRequest dnaRequest){
        StringBuilder stringBuilder = new StringBuilder(dnaRequest.getDna().size()*dnaRequest.getDna().size());
        for(String row: dnaRequest.getDna()){
            stringBuilder.append(row.toUpperCase());
        }
        return stringBuilder.toString();
    }
}
