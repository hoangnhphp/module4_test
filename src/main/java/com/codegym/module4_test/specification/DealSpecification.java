package com.codegym.module4_test.specification;

import com.codegym.module4_test.entity.Customer;
import com.codegym.module4_test.entity.Deal;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DealSpecification {
    public static Specification<Deal> searchWithFilters(Map<String, String> search) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            search.forEach((key, value) -> {
                if (value != null && !value.isEmpty()) {
                    switch (key) {
                        case "customer_name":
                            Join<Deal, Customer> customerJoin = root.join("customer");
                            predicates.add(criteriaBuilder.like(customerJoin.get("name"), "%" + value + "%"));
                            break;
                        case "dealType":
                            predicates.add(criteriaBuilder.equal(root.get("dealType"), value));
                            break;
                        default:
                            break;
                    }
                }
            });

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}