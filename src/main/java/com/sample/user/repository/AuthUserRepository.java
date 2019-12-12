package com.sample.user.repository;

import com.sample.models.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByUserName(String userName);
}
