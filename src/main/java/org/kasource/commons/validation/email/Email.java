package org.kasource.commons.validation.email;

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

import org.kasource.commons.validation.email.impl.EmailValidator;
import org.kasource.commons.validation.email.impl.ArrayEmailValidator;
import org.kasource.commons.validation.email.impl.IterableEmailValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {EmailValidator.class,
                           ArrayEmailValidator.class,
                           IterableEmailValidator.class})
public @interface Email {
    String message() default "is not a valid email address";

    boolean allowLocalAddresses() default false;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
