package org.kasource.validation.phone;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.kasource.validation.phone.impl.ArrayPhoneValidator;
import org.kasource.validation.phone.impl.IterablePhoneValidator;
import org.kasource.validation.phone.impl.PhoneValidator;



@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {PhoneValidator.class, 
                           ArrayPhoneValidator.class,
                           IterablePhoneValidator.class})
public @interface Phone {
    String message() default "{validation.message.phone}";
    
    String country() default "";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
