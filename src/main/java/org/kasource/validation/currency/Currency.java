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

import org.kasource.validation.currency.impl.ArrayCurrencyValidator;
import org.kasource.validation.currency.impl.CurrencyValidator;
import org.kasource.validation.currency.impl.IterableCurrencyValidator;

/**
 * Validates currency code  (ISO 4217)
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {CurrencyValidator.class,
                           ArrayCurrencyValidator.class,
                           IterableCurrencyValidator.class})
public @interface Currency {
    
    CurrencyCode[] value() default {};
    
    CurrencyCodeType currencyType() default CurrencyCodeType.CURRENCY;
    
    boolean caseSensetive() default false;
    
    String message() default  "{org.kasource.validation.currency.Currency}";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
