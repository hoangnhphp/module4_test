package com.codegym.module4_test.service;

import com.codegym.module4_test.entity.Customer;

public interface ICustomerService extends IService<Customer> {

    String generateNewId();
}
