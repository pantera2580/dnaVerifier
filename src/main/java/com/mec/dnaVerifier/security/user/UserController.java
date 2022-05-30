package com.mec.dnaVerifier.security.user;

import com.mec.dnaVerifier.exception.RoleNotFoundException;
import com.mec.dnaVerifier.security.abstraction.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register a user", description = "Register a user, available for all", responses = {
            @ApiResponse(responseCode = "201", description = "Successful register"),
            @ApiResponse(responseCode = "400", description = "Invalid User supplied", content = @Content),

    })
    @PostMapping(value = "/register", produces = {"application/json"})
    public ResponseEntity<UserDetailsResponse> register(@Valid @RequestBody UserDetailsRequest userDetailsRequest, BindingResult bindingResult) throws RoleNotFoundException {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByUsername(userDetailsRequest.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(userDetailsRequest.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserDetailsResponse userDetailsResponse = userService.save(userDetailsRequest);
        return new ResponseEntity<>(userDetailsResponse, HttpStatus.CREATED);
    }
    @Operation(summary = "Login", description = "Login a user in the api", responses = {
            @ApiResponse(responseCode = "200", description = "Successful login"),
            @ApiResponse(responseCode = "400", description = "Bad User supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not Found", content = @Content)

    })
    @PostMapping(value = "/login", produces = {"application/json"})
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!userService.existsByUsername(loginRequest.getUsername())) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LoginResponse loginResponse = userService.login(loginRequest);

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
