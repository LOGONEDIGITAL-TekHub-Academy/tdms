package com.logonedigital.tdms.infrastructure.persistence.entity;

import com.logonedigital.tdms.domain.model.shared.vo.Email;
import com.logonedigital.tdms.domain.model.shared.vo.FullName;
import com.logonedigital.tdms.domain.model.user.Role;
import com.logonedigital.tdms.domain.model.user.UserId;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbId;
    private UUID userId;
    private String fullName;
    private String email;
    private String password;
    private boolean enabled;
    private boolean accountLocked;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_dbId"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
