package com.logonedigital.tdms.domain.model.user;

public interface UserRepository {
    UserDomain save(UserDomain user);
    UserDomain findByEmail(String email);
}
