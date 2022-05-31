package com.mec.dnaVerifier.dna;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsControllers {
    @Autowired
    IDnaService dnaService;
    @Operation(summary = "DNA Stats", description = "Stats of verifier dna", responses = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
    })
    @GetMapping(produces = {"application/json"})
    public ResponseEntity<StatsResponse> stats(){
        return new ResponseEntity<StatsResponse>(dnaService.statics(), HttpStatus.OK);
    }
}
