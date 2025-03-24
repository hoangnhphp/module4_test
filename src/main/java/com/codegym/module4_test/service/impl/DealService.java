package com.codegym.module4_test.service.impl;

import com.codegym.module4_test.entity.Deal;
import com.codegym.module4_test.repository.IDealRepository;
import com.codegym.module4_test.service.IDealService;
import com.codegym.module4_test.specification.DealSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DealService implements IDealService {

    @Autowired
    private IDealRepository dealRepository;

    @Override
    public List<Deal> getAll() {
        return List.of();
    }

    @Override
    public void save(Deal s) {
        dealRepository.save(s);
    }

    @Override
    public void update(long id, Deal s) {

    }

    @Override
    public void remove(Long id) {
        dealRepository.deleteById(id);
    }

    @Override
    public Deal findById(long id) {
        return dealRepository.findById(id).orElse(null);
    }

    @Override
    public List<Deal> findByName(String name) {
        return List.of();
    }

    @Override
    public List<Deal> getDeals(Map<String, String> search) {
        Specification<Deal> spec = DealSpecification.searchWithFilters(search);

        return dealRepository.findAll(spec);
    }

    @Override
    public String generateNewId() {
        Optional<String> lastIdOpt = dealRepository.findLastId();

        int newNumber = 1; // Mặc định là KH-0001 nếu chưa có ID nào

        if (lastIdOpt.isPresent()) {
            String lastId = lastIdOpt.get(); // Ví dụ: "KH-0023"
            String numberPart = lastId.substring(3); // "0023"
            newNumber = Integer.parseInt(numberPart) + 1; // 23 + 1 = 24
        }

        return String.format("MGD-%04d", newNumber); // Format thành "KH-0024"
    }

    @Override
    public Deal getDealByCode(String code) {
        return dealRepository.findByCode(code);
    }

}