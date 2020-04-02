package com.termos.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)

@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface EmailValidation {
    String message() default "Email invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
