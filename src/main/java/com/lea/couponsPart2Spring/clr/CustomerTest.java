package com.lea.couponsPart2Spring.clr;

import com.lea.couponsPart2Spring.beans.Categories;
import com.lea.couponsPart2Spring.beans.ClientDetails;
import com.lea.couponsPart2Spring.beans.ClientType;
import com.lea.couponsPart2Spring.services.LoginService;
import com.lea.couponsPart2Spring.services.serviceImpl.CustomerServiceImpl;
import com.lea.couponsPart2Spring.utils.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(4)
public class CustomerTest implements CommandLineRunner {
    private final LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
        CustomerServiceImpl customerService = (CustomerServiceImpl) loginService.login(
                new ClientDetails("orenlevi6@gmail.com", "orenOren", ClientType.CUSTOMER));

        System.out.println("Purchase coupon");
        customerService.purchaseCoupon(1);
        TablePrinter.print(customerService.getAllCustomerCoupons());

        System.out.println("Get coupons by category - FOOD");
        TablePrinter.print(customerService.getAllCustomerCouponsByCategory(Categories.FOOD));

        System.out.println("Get coupons by max price - 50");
        TablePrinter.print(customerService.getAllCustomerCouponsByMaxPrice(50));

        System.out.println("Get customer #1 details");
//        TablePrinter.print(customerService.getCustomerDetails()); doesn't work - failed to lazily initialize
        System.out.println(customerService.getCustomerDetails());
    }

}
