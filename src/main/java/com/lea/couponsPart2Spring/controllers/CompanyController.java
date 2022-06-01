package com.lea.couponsPart2Spring.controllers;

import com.lea.couponsPart2Spring.beans.Categories;
import com.lea.couponsPart2Spring.beans.ClientType;
import com.lea.couponsPart2Spring.beans.Coupon;
import com.lea.couponsPart2Spring.exceptions.LoginException;
import com.lea.couponsPart2Spring.exceptions.NotExistException;
import com.lea.couponsPart2Spring.exceptions.TokenException;
import com.lea.couponsPart2Spring.services.serviceImpl.CompanyServiceImpl;
import com.lea.couponsPart2Spring.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final JWT jwt;
    private final CompanyServiceImpl companyService;

    @PostMapping("/addCoupon")
    public ResponseEntity<?> addCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        companyService.addCoupon(coupon);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Coupon added Successfully");
    }

    @PutMapping("/updateCoupon")
    public ResponseEntity<?> updateCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);

        companyService.updateCoupon(coupon);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .build();
    }

    @DeleteMapping("/deleteCoupon/{couponID}")
    public ResponseEntity<?> deleteCoupon(@RequestHeader(name = "Authorization") String token, @PathVariable int couponID) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);

        companyService.deleteCoupon(couponID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .build();
    }

    @GetMapping("/getAllCompanyCoupons")
    public ResponseEntity<?> getAllCompanyCoupons(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCoupons());
    }

    @GetMapping("/getAllCompanyCouponsByCategory/{category}")
    public ResponseEntity<?> getAllCompanyCouponsByCategory(@RequestHeader(name = "Authorization") String token, @PathVariable Categories category) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCouponsByCategory(category));
    }

    @GetMapping("/getAllCompanyCouponsByMaxPrice/{maxPrice}")
    public ResponseEntity<?> getAllCompanyCouponsByMaxPrice(@RequestHeader(name = "Authorization") String token, @PathVariable double maxPrice) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCouponsByMaxPrice(maxPrice));
    }

    @GetMapping("/getCompanyDetails")
    public ResponseEntity<?> getCompanyDetails(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getCompanyDetails());
    }

}
