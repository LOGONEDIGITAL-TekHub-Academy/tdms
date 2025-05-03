package com.logonedigital.tdms.application.user.usecases;

import com.logonedigital.tdms.domain.shared.vo.Email;
import com.logonedigital.tdms.domain.shared.vo.FullName;
import com.logonedigital.tdms.domain.user.UserDomain;
import com.logonedigital.tdms.domain.user.UserService;
import com.logonedigital.tdms.infrastructure.user.http.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public RegisterUserService(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public UserDomain saveTechDreamer(RegisterRequest request){
        var fullName = new FullName(request.firstName(),request.lastName());
        var email = new Email(request.email());
        var password = passwordEncoder.encode(request.password());
        return userService.saveTechDreamer(fullName, email, password);
    }

    public UserDomain saveAdmin(RegisterRequest request){
        var fullName = new FullName(request.firstName(),request.lastName());
        var email = new Email(request.email());
        var password = passwordEncoder.encode(request.password());
        return userService.saveAdmin(fullName, email, password);
    }

    public UserDomain saveTechMentor(RegisterRequest request){
        var fullName = new FullName(request.firstName(),request.lastName());
        var email = new Email(request.email());
        var password = passwordEncoder.encode(request.password());
        return userService.saveTechMentor(fullName, email, password);
    }


}
