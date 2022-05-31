package com.mec.dnaVerifier.dna;

import com.mec.dnaVerifier.exception.InvalidNitrogenousBaseException;
import com.mec.dnaVerifier.exception.NotReachMinimumLengthException;
import com.mec.dnaVerifier.exception.NotSquareArrayException;
import com.mec.dnaVerifier.util.DnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DnaService implements IDnaService{
    @Autowired
    IDnaRepository dnaRepository;
    @Autowired
    SequenceValidator dnaValidator;
    @Autowired
    SequenceProcessor sequenceProcessor;
    private final int MIN_LENGTH = 4;

    @Override
    public DnaResponse processorDna(DnaRequest dnaRequest) throws NotReachMinimumLengthException, InvalidNitrogenousBaseException, NotSquareArrayException {
        Optional<Dna> dna = dnaRepository.findBySequence(DnaMapper.dnaStructureToString(dnaRequest));
        DnaResponse dnaResponse = new DnaResponse();
        if(dna.isEmpty()) {
            dnaResponse.setStructureToString(DnaMapper.dnaStructureToString(dnaRequest));
            dnaResponse.setMalformed(this.sequenceProcessor.sequenceFinder(this.generateValidDnaStructure(dnaRequest), MIN_LENGTH));
            dnaResponse.setCreatedAt(new Date());
            dnaResponse.setDimension(dnaRequest.getDna().size());
            this.save(dnaResponse);
            return dnaResponse;
        }
        dnaResponse = DnaMapper.entityToResponse(dna.get());
        return dnaResponse;
    }

    @Override
    public void save(DnaResponse dnaResponse) {
        dnaRepository.save(DnaMapper.responseToEntity(dnaResponse));
    }

    @Override
    public StatsResponse statics() {
        StatsResponse statsResponse = new StatsResponse();
        long correct = dnaRepository.countByIsMalformed(false);
        long defect = dnaRepository.countByIsMalformed(true);
        statsResponse.setCount_correct_dna(correct);
        statsResponse.setCount_defect_dna(defect);
        statsResponse.setRatio((double) correct/defect);
        return statsResponse;
    }

    private char[][] generateValidDnaStructure(DnaRequest dnaRequest) throws NotReachMinimumLengthException, InvalidNitrogenousBaseException, NotSquareArrayException {
        return this.dnaValidator.generateValidDnaStructure(dnaRequest, MIN_LENGTH);
    }

}
