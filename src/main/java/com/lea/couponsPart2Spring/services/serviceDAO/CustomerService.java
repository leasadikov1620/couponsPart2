package com.lea.couponsPart2Spring.services.serviceDAO;

import com.lea.couponsPart2Spring.beans.Categories;
import com.lea.couponsPart2Spring.beans.Coupon;
import com.lea.couponsPart2Spring.beans.Customer;
import com.lea.couponsPart2Spring.exceptions.AlreadyExistsException;
import com.lea.couponsPart2Spring.exceptions.NotExistException;

import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int couponID) throws NotExistException, AlreadyExistsException;

    List<Coupon> getAllCustomerCoupons() throws NotExistException;

    List<Coupon> getAllCustomerCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCustomerCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Customer getCustomerDetails();
}
