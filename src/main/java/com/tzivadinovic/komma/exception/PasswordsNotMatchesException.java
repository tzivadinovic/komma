package com.tzivadinovic.komma.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@ResponseStatus(value = FORBIDDEN, reason = "Password don't matches")
public class PasswordsNotMatchesException extends RuntimeException {

    @ResponseStatus(value = FORBIDDEN, reason = "New and repeated passwords don't matches")
    public static final class RepeatedAndNewPasswordDontMatches extends PasswordsNotMatchesException {
    }

}
