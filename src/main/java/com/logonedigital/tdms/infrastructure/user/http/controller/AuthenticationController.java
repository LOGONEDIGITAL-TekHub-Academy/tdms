package com.logonedigital.tdms.infrastructure.user.http.controller;

import com.logonedigital.tdms.application.usecases.AuthenticateUser;
import com.logonedigital.tdms.infrastructure.user.http.dto.AuthenticationRequest;
import com.logonedigital.tdms.infrastructure.user.http.dto.AuthenticationResponse;
import com.logonedigital.tdms.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class AuthenticationController {
    private final AuthenticateUser service;


    public AuthenticationController(AuthenticateUser authenticateUser) {
        this.service = authenticateUser;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ){
        AuthenticationResponse response = service.authenticate(request);
        return ResponseEntity.ok(new ApiResponse("Successfully authenticated", response));
    }
}
