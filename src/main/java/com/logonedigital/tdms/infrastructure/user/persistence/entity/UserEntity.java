package com.logonedigital.tdms.infrastructure.user.persistence.entity;

import com.logonedigital.tdms.domain.shared.vo.Email;
import com.logonedigital.tdms.domain.shared.vo.FullName;
import com.logonedigital.tdms.domain.user.Role;
import com.logonedigital.tdms.domain.user.UserDomain;
import com.logonedigital.tdms.domain.user.UserId;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_user")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbId;
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;
    private boolean accountLocked;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_dbId"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public static UserEntity fromDomain(UserDomain user) {

        return UserEntity.builder()
                .dbId(user.getDbId())
                .userId(user.getUserId().value())
                .firstName(user.getFullName().firstName())
                .lastName(user.getFullName().lastName())
                .email(user.getEmail().value())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .accountLocked(user.isAccountLocked())
                .roles(user.getRoles())
                .build();
    }

    public static UserDomain toDomain(UserEntity userEntity) {
        return UserDomain.builder()
                .dbId(userEntity.getDbId())
                .userId(new UserId(userEntity.getUserId()))
                .fullName(new FullName(userEntity.getFirstName(), userEntity.getLastName()))
                .email(new Email(userEntity.getEmail()))
                .password(userEntity.getPassword())
                .enabled(userEntity.isEnabled())
                .accountLocked(userEntity.isAccountLocked())
                .roles(userEntity.getRoles())
                .build();
    }

}
