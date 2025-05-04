package com.logonedigital.tdms.infrastructure.user.http.controller;

import com.logonedigital.tdms.application.usecases.RegisterUser;
import com.logonedigital.tdms.infrastructure.user.http.dto.RegisterRequest;
import com.logonedigital.tdms.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth/register")
@RestController
public class UserController {
    private final RegisterUser userService;
    public UserController(RegisterUser service) {
        this.userService = service;
    }

    @PostMapping("/admin")
    public ResponseEntity<ApiResponse> saveAdmin(@RequestBody @Valid RegisterRequest request) {
        var user =userService.saveAdmin(request);
        return ResponseEntity.ok(new ApiResponse("Successfully registered user", user.getUserId()));
    }

    @PostMapping("/techdreamer")
    public ResponseEntity<ApiResponse> saveTechDreamer(@RequestBody @Valid RegisterRequest request) {
        var user = userService.saveTechDreamer(request);
        return ResponseEntity.ok(new ApiResponse("Successfully registered user", user.getUserId()));
    }

    @PostMapping("/techmentor")
    public ResponseEntity<ApiResponse> saveTechMentor(@RequestBody @Valid RegisterRequest request) {
        var user = userService.saveTechMentor(request);
        return ResponseEntity.ok(new ApiResponse("Successfully registered user", user.getUserId()));
    }
}
