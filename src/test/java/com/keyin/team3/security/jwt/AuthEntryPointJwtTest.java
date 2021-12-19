package com.keyin.team3.security.jwt;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AccountExpiredException;

class AuthEntryPointJwtTest {
    @Test
    void testCommence() throws IOException {
        AuthEntryPointJwt authEntryPointJwt = new AuthEntryPointJwt();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = mock(Response.class);
        doNothing().when(response).sendError(anyInt(), (String) any());
        authEntryPointJwt.commence(request, response, new AccountExpiredException("Msg"));
        verify(response).sendError(anyInt(), (String) any());
    }
}

