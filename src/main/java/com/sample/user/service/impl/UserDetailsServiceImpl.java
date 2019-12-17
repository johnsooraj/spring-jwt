package com.sample.user.service.impl;

import com.sample.models.UserCredentials;
import com.sample.models.UserDetails;
import com.sample.models.UserRoles;
import com.sample.user.repository.UserDetailsRepository;
import com.sample.user.repository.UserRolesRepository;
import com.sample.user.service.UserDetailsService;
import com.sample.user.service.UserRolesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void createDummyUser() {
        //UserCredentials userCredentials = new UserCredentials("john", passwordEncoder.encode("john"));
        UserDetails userDetails1 = userDetailsRepository.save(getMyUser("john", "john", "User 1"));
        log.info("new user added id {}", userDetails1.getId());
    }

    public UserDetails getMyUser(String username, String password, String fullName) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUserName(username);
        //userCredentials.setPassword(passwordEncoder.encode(password));
        userCredentials.setPassword(password);
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(fullName);
        userDetails.setUserCredentials(userCredentials);
        userDetails.setUserRoles(Stream.of(
                userRolesRepository.findByRoleText("ADMIN"),
                userRolesRepository.findByRoleText("GUEST"),
                userRolesRepository.findByRoleText("MANAGER")
        ).collect(Collectors.toSet()));
        userCredentials.setUserDetails(userDetails);
        return userDetails;
    }

    @Override
    public UserDetails findUserById(Long id) {
        return userDetailsRepository.findById(id).get();
    }

    @Override
    public List<UserDetails> findUserByName(String name, boolean conditional) {
        if (!conditional) {
            return Arrays.asList(userDetailsRepository.findByFirstName(name));
        } else {
            return userDetailsRepository.findAllByFirstNameStartingWith(name);
        }
    }
}
