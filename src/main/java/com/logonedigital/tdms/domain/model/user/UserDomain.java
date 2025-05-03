package com.logonedigital.tdms.domain.model.user;

import com.logonedigital.tdms.domain.model.shared.vo.Email;
import com.logonedigital.tdms.domain.model.shared.vo.FullName;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDomain {
    private Long dbId;
    private UserId userId;
    private FullName fullName;
    private Email email;
    private String password;
    private boolean enabled;
    private boolean accountLocked;
    private Set<Role> roles;

    public static UserDomain create
            (FullName fullName, Email email, String password)
    {
        return UserDomain.builder()
                .userId(UserId.generate())
                .fullName(fullName)
                .email(email)
                .password(password)
                .enabled(true)
                .accountLocked(false)
                .build();
    }
}
