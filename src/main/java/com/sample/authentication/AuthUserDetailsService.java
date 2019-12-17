package com.sample.authentication;

import com.sample.models.UserCredentials;
import com.sample.models.UserRoles;
import com.sample.user.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserCredentials> userCredentials = authUserRepository.findByUserName(s);
        userCredentials.orElseThrow(() -> new UsernameNotFoundException("No user data found with username :" + s));
        return createUserDeatils(userCredentials.get());
    }

    private UserDetails createUserDeatils(UserCredentials credentials) {
        return new User(credentials.getUserName(),
                String.valueOf(credentials.getPassword()),
                true, true, true, true,
                AuthUtils.getGrantedAuthorityFromRoles(credentials.getUserDetails().getUserRoles()));
    }
}