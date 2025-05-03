package com.logonedigital.tdms.infrastructure.user.http.controller;

import com.logonedigital.tdms.application.usecases.RegisterUserService;
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
    private final RegisterUserService userService;
    public UserController(RegisterUserService service) {
        this.userService = service;
    }

    @PostMapping("/admin")
    public ResponseEntity<ApiResponse> saveAdmin(@RequestBody @Valid RegisterRequest request) {
        userService.saveAdmin(request);
        return ResponseEntity.ok(new ApiResponse("Successfully registered user", null));
    }

    @PostMapping("/techdreamer")
    public ResponseEntity<ApiResponse> saveTechDreamer(@RequestBody @Valid RegisterRequest request) {
        userService.saveTechDreamer(request);
        return ResponseEntity.ok(new ApiResponse("Successfully registered user", null));
    }

    @PostMapping("/techmentor")
    public ResponseEntity<ApiResponse> saveTechMentor(@RequestBody @Valid RegisterRequest request) {
        userService.saveTechDreamer(request);
        return ResponseEntity.ok(new ApiResponse("Successfully registered user", null));
    }
}
