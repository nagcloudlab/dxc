package com.example.auth;

import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities=
                dbUser.getRoles()
                        .stream()
                        .map(role->new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(dbUser.getUsername(), dbUser.getPassword(),authorities);
        return userDetails;
    }
}
