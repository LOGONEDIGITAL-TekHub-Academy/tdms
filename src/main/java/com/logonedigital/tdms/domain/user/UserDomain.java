package com.logonedigital.tdms.domain.user;

import com.logonedigital.tdms.domain.shared.vo.Email;
import com.logonedigital.tdms.domain.shared.vo.FullName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
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
