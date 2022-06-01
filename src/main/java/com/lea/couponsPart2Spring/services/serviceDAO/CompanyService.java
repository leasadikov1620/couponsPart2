package com.lea.couponsPart2Spring.services.serviceDAO;


import com.lea.couponsPart2Spring.beans.Categories;
import com.lea.couponsPart2Spring.beans.Company;
import com.lea.couponsPart2Spring.beans.Coupon;
import com.lea.couponsPart2Spring.exceptions.NotExistException;

import java.util.List;

public interface CompanyService {

    void addCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon) throws NotExistException;

    void deleteCoupon(int couponID) throws NotExistException;

    List<Coupon> getAllCompanyCoupons() throws NotExistException;

    List<Coupon> getAllCompanyCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCompanyCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Company getCompanyDetails();
}
