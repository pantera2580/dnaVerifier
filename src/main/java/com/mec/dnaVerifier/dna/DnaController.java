package com.mec.dnaVerifier.dna;

import com.mec.dnaVerifier.exception.InvalidNitrogenousBaseException;
import com.mec.dnaVerifier.exception.NotReachMinimumLengthException;
import com.mec.dnaVerifier.exception.NotSquareArrayException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class DnaController {

    @Autowired
    IDnaService dnaService;
    @Operation(summary = "DNA Verifier", description = "Verifier if a dna have malformations", responses = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "400", description = "Bad Array supplied", content = @Content),
    })
    @PostMapping(produces = {"application/json"})
    public ResponseEntity<DnaResponse> verifyDna(@RequestBody DnaRequest dnaRequest) throws NotReachMinimumLengthException, InvalidNitrogenousBaseException, NotSquareArrayException {
        DnaResponse dnaResponse = dnaService.processorDna(dnaRequest);
        return new ResponseEntity<>(dnaResponse , HttpStatus.OK );
    }

}
