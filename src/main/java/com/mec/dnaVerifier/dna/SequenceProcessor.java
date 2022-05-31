package com.mec.dnaVerifier.dna;

import com.mec.dnaVerifier.security.jwt.JwtEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SequenceProcessor {
    private final static Logger LOGGER = LoggerFactory.getLogger(JwtEntryPoint.class);
    public boolean sequenceFinder(char[][] dna, int match) {
        LOGGER.debug("sequenceFinder init...");
        for(int i=0;i<dna.length;i++) {
            for(int j=0; j<dna[i].length;j++){
                if(horizontalProcessor(dna, i, j, match)) {
                    LOGGER.debug("Match horizontal found");
                    return true;
                }
                if(verticalProcessor(dna, i, j, match)){
                    LOGGER.debug("Match vertical found");
                    return true;
                }
                if(diagonalProcessor(dna,i,j,match)){
                    LOGGER.debug("Match diagonal found");
                    return true;
                }
            }
        }
        LOGGER.debug("Match not found");
        return false;
    }

    private boolean horizontalProcessor(char[][] dna, int row, int col, int match){
        LOGGER.debug("horizontal Processor init...");
        int countMatch=1;
        if(col+match<=dna.length) {
            LOGGER.debug("horizontal index verified");
            while (countMatch < match && dna[row][col] == dna[row][col + countMatch]) {
                //LOGGER.debug("countMatch {}", countMatch);
                countMatch++;
            }
        }
        return countMatch==match;
    }
    private boolean verticalProcessor(char[][] dna, int row, int col, int match){
        LOGGER.debug("vertical Processor init...");
        int countMatch=1;
        if(row+match<=dna.length) {
            LOGGER.debug("vertical index verified");
            while (countMatch < match && dna[row][col] == dna[row + countMatch][col]) {
                //LOGGER.debug("countMatch {}", countMatch);
                countMatch++;
            }
        }
        return countMatch==match;
    }
    private boolean diagonalProcessor(char[][] dna, int row, int col, int match){
        LOGGER.debug("diagonal Processor init...");
        int countMatch=1;
        if(row+match<=dna.length && col+match<= dna.length) {
            LOGGER.debug("diagonal indexes verified");
            while (countMatch < match && dna[row][col] == dna[row + countMatch][col + countMatch]) {
                //LOGGER.debug("countMatch {}", countMatch);
                countMatch++;
            }
        }
        return countMatch==match;
    }
}
