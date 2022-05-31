package com.mec.dnaVerifier.dna;

import com.mec.dnaVerifier.exception.InvalidNitrogenousBaseException;
import com.mec.dnaVerifier.exception.NotReachMinimumLengthException;
import com.mec.dnaVerifier.exception.NotSquareArrayException;
import com.mec.dnaVerifier.security.jwt.JwtEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
@Component
public class SequenceValidator {
    private final static Logger LOGGER = LoggerFactory.getLogger(JwtEntryPoint.class);
    private final Pattern DNA_PATTERN = Pattern.compile("[atgc]+", Pattern.CASE_INSENSITIVE);

    public char[][] generateValidDnaStructure(DnaRequest dnaRequest, int minLength) throws NotReachMinimumLengthException, InvalidNitrogenousBaseException, NotSquareArrayException {
        LOGGER.debug("Generate valid char[][] of dnaRequest");
        int size = dnaRequest.getDna().size();
        char[][] dna = new char[size][size];
        validateDnaRequest(dnaRequest, minLength);
        for(int i=0; i<size;i++){
            String row = dnaRequest.getDna().get(i);
            dna[i] = row.toUpperCase().toCharArray();
        }
        return dna;
    }
    private void validateDnaRequest(DnaRequest dnaRequest, int minLength) throws NotSquareArrayException, NotReachMinimumLengthException, InvalidNitrogenousBaseException {
        if(!this.minimunLength(dnaRequest, minLength)) throw new NotReachMinimumLengthException("Does not reach the minimum length");
        if(!this.isSquare(dnaRequest)) throw new NotSquareArrayException("Non square matrix");
        if(!this.isValidDna(dnaRequest)) throw new InvalidNitrogenousBaseException("Invalid nitrogenous base provided");
    }
    private boolean minimunLength(DnaRequest dnaRequest, int minLength){
        if(dnaRequest.getDna().size()<minLength) return false;
        for(String row : dnaRequest.getDna()){
            if(row.length()<minLength) return false;
        }
        return true;
    }
    private boolean isSquare(DnaRequest dnaRequest){
        for(String row: dnaRequest.getDna()){
            if(row.length()!=dnaRequest.getDna().size()) return false;
        }
        return true;
    }
    private boolean isValidDna(DnaRequest dnaRequest){
        LOGGER.debug("Valid characters: A, T, C e G.");
        for(String row: dnaRequest.getDna()){
            if(!DNA_PATTERN.matcher(row).matches()){
                return false;
            }
        }
        return true;
    }

}
