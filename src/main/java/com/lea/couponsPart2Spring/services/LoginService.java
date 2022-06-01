package com.lea.couponsPart2Spring.services;

import com.lea.couponsPart2Spring.beans.ClientDetails;
import com.lea.couponsPart2Spring.exceptions.LoginException;
import com.lea.couponsPart2Spring.services.serviceImpl.AdminServiceImpl;
import com.lea.couponsPart2Spring.services.serviceImpl.CompanyServiceImpl;
import com.lea.couponsPart2Spring.services.serviceImpl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    public ClientService login(ClientDetails clientDetails) throws LoginException {
        ClientService clientService = null;
        switch (clientDetails.getClientType()) {
            case ADMIN:
                clientService = adminService;
                break;
            case COMPANY:
                clientService = companyService;
                break;
            case CUSTOMER:
                clientService = customerService;
        }
        if (clientService.login(clientDetails.getEmail(), clientDetails.getPassword())) {
            return clientService;
        }
        throw new LoginException(clientDetails.getClientType());
    }

}
