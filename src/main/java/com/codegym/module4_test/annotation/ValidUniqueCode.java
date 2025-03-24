package com.codegym.module4_test.annotation;


import com.codegym.module4_test.rule.UniqueCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueCodeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUniqueCode {
    String message() default "Mã giao dịch không được phép trùng";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
