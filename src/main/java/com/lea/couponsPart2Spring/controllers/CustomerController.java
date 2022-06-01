package com.lea.couponsPart2Spring.controllers;

import com.lea.couponsPart2Spring.beans.Categories;
import com.lea.couponsPart2Spring.beans.ClientType;
import com.lea.couponsPart2Spring.exceptions.AlreadyExistsException;
import com.lea.couponsPart2Spring.exceptions.LoginException;
import com.lea.couponsPart2Spring.exceptions.NotExistException;
import com.lea.couponsPart2Spring.exceptions.TokenException;
import com.lea.couponsPart2Spring.services.serviceImpl.CustomerServiceImpl;
import com.lea.couponsPart2Spring.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final JWT jwt;
    private final CustomerServiceImpl customerService;

    @PostMapping("/purchaseCoupon/{couponID}")
    public ResponseEntity<?> purchaseCoupon(@RequestHeader(name = "Authorization") String token, @PathVariable int couponID) throws TokenException, LoginException, NotExistException, AlreadyExistsException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        customerService.purchaseCoupon(couponID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .build();
    }

    @GetMapping("/getCustomerCoupons")
    public ResponseEntity<?> getCustomerCoupons(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCoupons());
    }

    @GetMapping("/getCustomerCouponsByCategory/{category}")
    public ResponseEntity<?> getCustomerCouponsByCategory(@RequestHeader(name = "Authorization") String token, @PathVariable Categories category) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCouponsByCategory(category));
    }

    @GetMapping("/getCustomerCouponsByMaxPrice/{maxPrice}")
    public ResponseEntity<?> getCustomerCouponsByMaxPrice(@RequestHeader(name = "Authorization") String token, @PathVariable double maxPrice) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCouponsByMaxPrice(maxPrice));
    }

    @GetMapping("/getCustomerDetails")
    public ResponseEntity<?> getCustomerDetails(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getCustomerDetails());
    }

}
