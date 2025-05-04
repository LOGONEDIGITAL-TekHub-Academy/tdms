package com.logonedigital.tdms.infrastructure.security;

import com.logonedigital.tdms.domain.user.UserDomain;
import com.logonedigital.tdms.domain.user.UserRepository;
import com.logonedigital.tdms.infrastructure.user.persistence.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UserDomain user = userRepository.findByEmail(userEmail);
        return UserEntity.toUserDetails(user);
    }

}
