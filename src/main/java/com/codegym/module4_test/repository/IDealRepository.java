package com.codegym.module4_test.repository;


import com.codegym.module4_test.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDealRepository extends JpaRepository<Deal, Long>, JpaSpecificationExecutor<Deal> {

    @Query(value = "SELECT k.code FROM giao_dich k WHERE k.code LIKE 'MGD-%' ORDER BY k.id DESC LIMIT 1")
    Optional<String> findLastId();

    Deal findByCode(String code);
}