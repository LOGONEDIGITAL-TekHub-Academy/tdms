package com.logonedigital.tdms.application.usecases;

import com.logonedigital.tdms.infrastructure.security.jwt.JwtService;
import com.logonedigital.tdms.infrastructure.user.http.dto.AuthenticationRequest;
import com.logonedigital.tdms.infrastructure.user.http.dto.AuthenticationResponse;
import com.logonedigital.tdms.infrastructure.user.persistence.entity.UserEntity;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticateUser {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticateUser(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse authenticate(@Valid AuthenticationRequest request) {
        //Appeler le authenticationManager
        //puis authentifier le req en utilisant le UsernamePasswordAuthenticationToken
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        //Enregistrer dans le SecurityContext
        SecurityContextHolder.getContext().setAuthentication(auth);
        //Additional claims
        var claims = new HashMap<String, Object>();
        // getting authenticated user principal
        var user = ((UserEntity)auth.getPrincipal());
        System.out.println(user);
        claims.put("fullName", user.fullName());
        //Generate le Json Web Token
        var jwt = jwtService.generateToken(claims,user);

        return AuthenticationResponse.builder().token(jwt).build();
    }

}
