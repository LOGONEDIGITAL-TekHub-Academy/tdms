package com.logonedigital.tdms.domain.model.user;

import com.logonedigital.tdms.domain.model.shared.vo.Email;
import com.logonedigital.tdms.domain.model.shared.vo.FullName;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDomain saveAdmin(FullName fullName, Email email, String password){
        UserDomain user = UserDomain.create(fullName, email, password);
        user.setRoles(Set.of(Role.ADMIN));
        return userRepository.save(user);
    }
    public UserDomain saveTechDreamer(FullName fullName, Email email, String password){
        UserDomain user = UserDomain.create(fullName, email, password);
        user.setRoles(Set.of(Role.TECHDREAMER));
        return userRepository.save(user);
    }

    public UserDomain saveTechMentor(FullName fullName, Email email, String password){
        UserDomain user = UserDomain.create(fullName, email, password);
        user.setRoles(Set.of(Role.TECHMENTOR));
        return userRepository.save(user);
    }
}
