package org.kasource.validation.isbn;

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

import org.kasource.validation.isbn.impl.IsbnValidator;
import org.kasource.validation.isbn.impl.ArrayIsbnValidator;
import org.kasource.validation.isbn.impl.IterableIsbnValidator;

/**
 * Support validation of both ISBN-10 and ISBN-13 values.
 * 
 * If values contains separators like dash (-) consider using @CheckDigt(Algorithm.ISBN) which
 * supports separator handling.
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {IsbnValidator.class, 
                           ArrayIsbnValidator.class, 
                           IterableIsbnValidator.class})
public @interface Isbn {
    String message() default "{org.kasource.validation.isbn.Isbn}";
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
