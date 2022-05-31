package com.mec.dnaVerifier.dna;

import com.mec.dnaVerifier.exception.InvalidNitrogenousBaseException;
import com.mec.dnaVerifier.exception.NotReachMinimumLengthException;
import com.mec.dnaVerifier.exception.NotSquareArrayException;
import org.springframework.stereotype.Service;

@Service
public interface IDnaService {
    public DnaResponse processorDna(DnaRequest dnaRequest) throws NotReachMinimumLengthException, InvalidNitrogenousBaseException, NotSquareArrayException;
    void save(DnaResponse dnaResponse);
    StatsResponse statics();
}
