package com.codegym.module4_test.repository;


import com.codegym.module4_test.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT k.code FROM khach_hang k WHERE k.code LIKE 'KH-%' ORDER BY k.id DESC LIMIT 1")
    Optional<String> findLastId();
}