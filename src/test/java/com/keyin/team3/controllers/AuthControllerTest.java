package com.keyin.team3.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.team3.model.mysql.User;
import com.keyin.team3.payload.request.LoginRequest;
import com.keyin.team3.payload.request.SignupRequest;
import com.keyin.team3.repository.mysql.RoleRepository;
import com.keyin.team3.repository.mysql.UserRepository;
import com.keyin.team3.security.jwt.JwtUtils;
import com.keyin.team3.security.services.UserDetailsImpl;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testAuthenticateUser() throws Exception {
        when(this.jwtUtils.generateJwtToken((org.springframework.security.core.Authentication) any())).thenReturn("ABC123");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken(
                        new UserDetailsImpl(123L, "janedoe", "jane.doe@example.org", "iloveyou", new ArrayList<>()),
                        "Credentials"));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"token\":\"ABC123\",\"type\":\"Bearer\",\"id\":123,\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\","
                                        + "\"roles\":[]}"));
    }

    @Test
    void testAuthenticateUser2() throws Exception {
        when(this.jwtUtils.generateJwtToken((org.springframework.security.core.Authentication) any())).thenReturn("?");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken(
                        new UserDetailsImpl(123L, "janedoe", "jane.doe@example.org", "iloveyou", new ArrayList<>()),
                        "Credentials"));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"token\":\"?\",\"type\":\"Bearer\",\"id\":123,\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\","
                                        + "\"roles\":[]}"));
    }

    @Test
    void testRegisterUser() throws Exception {
        when(this.userRepository.existsByUsername((String) any())).thenReturn(true);

        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("jane.doe@example.org");
        signupRequest.setPassword("iloveyou");
        signupRequest.setRole(new HashSet<>());
        signupRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(signupRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Error: Username is already taken!\"}"));
    }

    @Test
    void testRegisterUser2() throws Exception {
        when(this.userRepository.existsByEmail((String) any())).thenReturn(true);
        when(this.userRepository.existsByUsername((String) any())).thenReturn(false);

        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("jane.doe@example.org");
        signupRequest.setPassword("iloveyou");
        signupRequest.setRole(new HashSet<>());
        signupRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(signupRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Error: Email is already in use!\"}"));
    }

    @Test
    void testRegisterUser3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.existsByEmail((String) any())).thenReturn(false);
        when(this.userRepository.existsByUsername((String) any())).thenReturn(false);
        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("jane.doe@example.org");
        signupRequest.setPassword("iloveyou");
        signupRequest.setRole(new HashSet<>());
        signupRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(signupRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"User registered successfully!\"}"));
    }

    @Test
    void testSplashPage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/auth/home");
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Welcome to the Page!\"}"));
    }

    @Test
    void testSplashPage2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/auth/home");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Welcome to the Page!\"}"));
    }
}

