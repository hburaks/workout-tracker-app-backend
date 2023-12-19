package com.hbdev.workouttrackerbackend.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmailWithRoles(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find User with email =" + email);
        }

        boolean isAdmin = user.get().getRoles().stream().anyMatch(role -> role.getName().equals("admin"));

        if (isAdmin) {
            return new User(email,
                    user.get().getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_admin")));
        }

        return new User(email,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_user")));
    }

}
