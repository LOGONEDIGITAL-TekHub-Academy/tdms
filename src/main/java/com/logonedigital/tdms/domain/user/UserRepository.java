package com.logonedigital.tdms.domain.user;

public interface UserRepository {
    UserDomain save(UserDomain user);
    UserDomain findByEmail(String email);
}
