package com.logonedigital.tdms.infrastructure.user.persistence.repository;

import com.logonedigital.tdms.domain.user.UserDomain;
import com.logonedigital.tdms.domain.user.UserRepository;
import com.logonedigital.tdms.infrastructure.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }


    @Override
    public UserDomain save(UserDomain user) {
        //Convertir UserDomain en UserEntity avant de persister
        UserEntity entityToSave = UserEntity.fromDomain(user);
        entityToSave.setAccountLocked(false);

        UserEntity savedEntity = jpaUserRepository.save(entityToSave);

        return UserEntity.toDomain(savedEntity);
    }

    @Override
    public UserDomain findByEmail(String email) {
        return null;
    }
}
