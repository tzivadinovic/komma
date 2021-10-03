package com.tzivadinovic.komma.security;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException {

        String redirectURL = "/?error=";
        if (exception instanceof DisabledException) {
            redirectURL += "disabled";
        } else if (exception instanceof BadCredentialsException) {
            redirectURL += "badCredentials";
        } else if (exception instanceof LockedException) {
            redirectURL += "locked";
        } else if (exception instanceof UsernameNotFoundException) {
            redirectURL += "notFound";
        } else if (exception instanceof AccountExpiredException || exception instanceof CredentialsExpiredException) {
            redirectURL += "expired";
        } else {
            redirectURL += "true";
        }
        response.sendRedirect(redirectURL);
    }
}
