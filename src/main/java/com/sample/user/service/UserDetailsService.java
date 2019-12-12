package com.sample.user.service;

import com.sample.models.UserDetails;

import java.util.List;

public interface UserDetailsService {

    void createDummyUser();

    UserDetails findUserById(Long id);

    /**
     * @param name        User's name as in db
     * @param conditional false - fetch data from DB, true - startWith Name
     * @return
     */
    List<UserDetails> findUserByName(String name, boolean conditional);
}
