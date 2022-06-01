package com.lea.couponsPart2Spring.controllers;

import com.lea.couponsPart2Spring.beans.ClientDetails;
import com.lea.couponsPart2Spring.exceptions.LoginException;
import com.lea.couponsPart2Spring.services.LoginService;
import com.lea.couponsPart2Spring.services.serviceImpl.AdminServiceImpl;
import com.lea.couponsPart2Spring.services.serviceImpl.CompanyServiceImpl;
import com.lea.couponsPart2Spring.services.serviceImpl.CustomerServiceImpl;
import com.lea.couponsPart2Spring.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final JWT jwt;
    private final LoginService loginService;
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody ClientDetails clientDetails) throws LoginException {
        if (loginService.login(clientDetails) == null) {
            throw new LoginException(clientDetails.getClientType());
        }
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(clientDetails))
                .build();
    }

}
