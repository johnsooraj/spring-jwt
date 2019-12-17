package com.sample.authentication;

import com.sample.models.UserRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public final class AuthUtils {

    public static Set<GrantedAuthority> getGrantedAuthorityFromRoles(Set<UserRoles> rolses) {
        return rolses.stream().map(UserRoles::getRole_text).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }
}
