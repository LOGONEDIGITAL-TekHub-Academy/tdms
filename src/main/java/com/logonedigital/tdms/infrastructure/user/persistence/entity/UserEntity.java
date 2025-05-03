package com.logonedigital.tdms.infrastructure.user.persistence.entity;

import com.logonedigital.tdms.domain.shared.vo.Email;
import com.logonedigital.tdms.domain.shared.vo.FullName;
import com.logonedigital.tdms.domain.user.Role;
import com.logonedigital.tdms.domain.user.UserDomain;
import com.logonedigital.tdms.domain.user.UserId;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_user")
@Entity
public class UserEntity implements UserDetails{

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }


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

    public static UserDetails toUserDetails(UserDomain user) {
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
}
