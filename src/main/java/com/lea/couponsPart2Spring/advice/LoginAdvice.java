package com.lea.couponsPart2Spring.advice;

import com.lea.couponsPart2Spring.exceptions.LoginException;
import com.lea.couponsPart2Spring.exceptions.TokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class LoginAdvice {
    @ExceptionHandler(value = {LoginException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleLoginException(Exception err) {
        return new ErrorDetails("Login Error", err.getMessage());
    }

    @ExceptionHandler(value = {TokenException.class, MalformedJwtException.class, SignatureException.class, ExpiredJwtException.class, DecodingException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleTokenException(Exception err) {
        return new ErrorDetails("Token Exception", "Invalid Token");
    }

}
