package com.sample.user.repository;

import com.sample.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByFirstName(String name);

    List<UserDetails> findAllByFirstNameStartingWith(String name);
}
