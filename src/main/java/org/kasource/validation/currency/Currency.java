package org.kasource.validation.currency;

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

import org.kasource.validation.enumeration.Enumeration;
import org.kasource.validation.enumeration.impl.ArrayEnumerationValidator;
import org.kasource.validation.enumeration.impl.EnumerationValidator;
import org.kasource.validation.enumeration.impl.IterableEnumerationValidator;



@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {EnumerationValidator.class,
                           ArrayEnumerationValidator.class,
                           IterableEnumerationValidator.class})
public @interface Currency {
    
    CurrencyCode[] value();
    
    boolean currencyOnly() default true;
    
    String message() default  "{validation.message.currency}";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
