package com.codegym.module4_test.service;

import com.codegym.module4_test.entity.Deal;

import java.util.List;
import java.util.Map;

public interface IDealService extends IService<Deal> {

    List<Deal> getDeals(Map<String, String> search);
    String generateNewId();
    Deal getDealByCode(String code);
}
