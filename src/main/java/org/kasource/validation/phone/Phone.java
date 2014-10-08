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


/**
 * Validate a phone number.
 * 
 * Default validation (no country specified) will validate that
 * the value is numeric only, after filtering out the separators space, dash, left and right parenthesis, dot and plus.
 * 
 * Setting the country attribute turns on <i>google libphonenumber check</i> with the specified country (region). 
 * 
 * Setting an invalid country will cause the validation to only allow international number format starting 
 * with + followed by the countryCode
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {PhoneValidator.class, 
                           ArrayPhoneValidator.class,
                           IterablePhoneValidator.class})
public @interface Phone {
    String message() default "{org.kasource.validation.phone.Phone}";
    
    /**
     * Country code  (ISO 3166 alpha-2)
     **/
    String country() default "";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
