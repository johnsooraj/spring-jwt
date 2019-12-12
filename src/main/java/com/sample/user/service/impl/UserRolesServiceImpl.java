package com.sample.user.service.impl;

import com.sample.models.UserRoles;
import com.sample.user.repository.UserRolesRepository;
import com.sample.user.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    UserRolesRepository userRolesRepository;

    @Override
    public void saveAllRoles() {
        List<UserRoles> rolesList = Arrays.asList(
                new UserRoles("ADMIN1"),
                new UserRoles("ADMIN2"),
                new UserRoles("ADMIN3"),
                new UserRoles("ADMIN4"),
                new UserRoles("ADMIN5"),
                new UserRoles("ADMIN6"),
                new UserRoles("ADMIN7"),
                new UserRoles("ADMIN8"),
                new UserRoles("ADMIN9"),
                new UserRoles("ADMIN10"),
                new UserRoles("ADMIN11"),
                new UserRoles("ADMIN12"),
                new UserRoles("ADMIN13"),
                new UserRoles("ADMIN14"),
                new UserRoles("ADMIN15")
        );
        userRolesRepository.saveAll(rolesList);
    }
}
