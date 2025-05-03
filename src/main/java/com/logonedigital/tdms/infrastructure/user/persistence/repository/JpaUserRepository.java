package com.logonedigital.tdms.infrastructure.user.persistence.repository;

import com.logonedigital.tdms.infrastructure.user.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity,Long> {
}
