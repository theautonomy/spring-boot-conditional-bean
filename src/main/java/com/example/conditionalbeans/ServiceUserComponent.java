package com.example.conditionalbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ServiceUserComponent {

    @Autowired(required = false)
    private ServiceA serviceA;

    @Autowired(required = false)
    private ServiceB serviceB;

    @PostConstruct
    public void useService() {
        if (serviceA != null) {
            serviceA.serve();
        }
        if (serviceB != null) {
            serviceB.serve();
        }
    }
}
