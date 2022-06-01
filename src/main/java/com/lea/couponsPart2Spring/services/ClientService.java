package com.lea.couponsPart2Spring.services;

import com.lea.couponsPart2Spring.repositories.CategoryRepo;
import com.lea.couponsPart2Spring.repositories.CompanyRepo;
import com.lea.couponsPart2Spring.repositories.CouponRepo;
import com.lea.couponsPart2Spring.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CategoryRepo categoryRepo;

    @Autowired
    protected CompanyRepo companyRepo;

    @Autowired
    protected CustomerRepo customerRepo;

    @Autowired
    protected CouponRepo couponRepo;

    public abstract boolean login(String email, String password);
}
