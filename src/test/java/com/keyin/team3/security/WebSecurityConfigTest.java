package com.keyin.team3.security;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.keyin.team3.repository.mysql.UserRepository;
import com.keyin.team3.security.jwt.AuthEntryPointJwt;
import com.keyin.team3.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;

class WebSecurityConfigTest {
    @Test
    void testPasswordEncoder() {
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(mock(UserRepository.class));
        assertTrue((new WebSecurityConfig(userDetailsService, new AuthEntryPointJwt()))
                .passwordEncoder() instanceof org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder);
    }
}

