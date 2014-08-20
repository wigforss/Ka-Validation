package org.kasource.commons.validation.isbn;

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

import org.kasource.commons.validation.isbn.impl.ApacheIsbnValidator;
import org.kasource.commons.validation.isbn.impl.ArrayApacheIsbnValidator;
import org.kasource.commons.validation.isbn.impl.IterableApacheIsbnValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {ApacheIsbnValidator.class, 
                           ArrayApacheIsbnValidator.class, 
                           IterableApacheIsbnValidator.class})
public @interface Isbn {
    String message() default "is not a valid email ISBN";
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
