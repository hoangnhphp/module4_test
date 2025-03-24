package com.codegym.module4_test.service.impl;

import com.codegym.module4_test.entity.Customer;
import com.codegym.module4_test.entity.Deal;
import com.codegym.module4_test.repository.ICustomerRepository;
import com.codegym.module4_test.service.ICustomerService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer s) {

    }

    @Override
    public void update(long id, Customer s) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Customer findById(long id) {
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        return List.of();
    }
    @Override
    public String generateNewId() {
        Optional<String> lastIdOpt = customerRepository.findLastId();

        int newNumber = 1; // Mặc định là KH-0001 nếu chưa có ID nào

        if (lastIdOpt.isPresent()) {
            String lastId = lastIdOpt.get(); // Ví dụ: "KH-0023"
            String numberPart = lastId.substring(3); // "0023"
            newNumber = Integer.parseInt(numberPart) + 1; // 23 + 1 = 24
        }

        return String.format("KH-%04d", newNumber); // Format thành "KH-0024"
    }


}