package com.codegym.module4_test.rule;

import com.codegym.module4_test.annotation.ValidUniqueCode;
import com.codegym.module4_test.entity.Deal;
import com.codegym.module4_test.service.IDealService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCodeValidator implements ConstraintValidator<ValidUniqueCode, String> {

    @Autowired
    private IDealService dealService;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        if (code == null) return false;

        if (dealService != null) {
            Deal deal = dealService.getDealByCode(code);
            if (deal != null) {
                return false;
            }
        }

        return true;
    }

    // Hàm helper để thêm lỗi cụ thể cho từng trường
    private void addConstraintViolation(ConstraintValidatorContext context, String field, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}